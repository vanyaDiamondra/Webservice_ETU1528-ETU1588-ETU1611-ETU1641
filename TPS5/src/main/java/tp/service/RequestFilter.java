package tp.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tp.model.Admins;
import tp.repository.AdminRepository;
import tp.repository.TokenAdminsRepository;

@Component
public class RequestFilter extends OncePerRequestFilter {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TokenAdminsRepository tokenAdminsRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        CustomUserDetailsService service = new CustomUserDetailsService();

        Admins admins = null;
        String Token = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            System.out.println("OK accepted Bearer Token");
            Token = requestTokenHeader.substring(7);
            admins = adminRepository.findUserByToken(Token);
        } else {
            System.out.println("JWT Token does not begin with Bearer String");
        }

        if (admins != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                boolean tokenIsExpired = service.tokenIsExpired(Token, tokenAdminsRepository);
                if( !tokenIsExpired ){
                    CustomUserDetails userDetails = new CustomUserDetails(admins);

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        chain.doFilter(request, response);
    }

}