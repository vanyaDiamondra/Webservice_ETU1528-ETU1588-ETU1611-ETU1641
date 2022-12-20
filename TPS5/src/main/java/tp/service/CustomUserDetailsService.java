package tp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tp.model.Admins;
import tp.model.TokenUtils;
import tp.repository.AdminRepository;
import tp.repository.TokenAdminsRepository;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      return null;
    }

    public Admins isLocked(String email, String password, AdminRepository rep){
        Admins admins = rep.findByEmail(email, password);
        if (admins == null) {
            return null;
        }
        return admins;
    }

    public boolean tokenIsExpired(String token, TokenAdminsRepository tokenAdminsRepository) throws Exception{
        TokenUtils tokenUtils =  tokenAdminsRepository.findToken(token).get(0);
        Date dateNow = new Date(System.currentTimeMillis());
        Timestamp expiration = new java.sql.Timestamp(dateNow.getTime());

        if( tokenUtils.getExpiration_date().compareTo(expiration) <= 0 ){
            throw new Exception("Token expired");
        }
        return false;
    }



}