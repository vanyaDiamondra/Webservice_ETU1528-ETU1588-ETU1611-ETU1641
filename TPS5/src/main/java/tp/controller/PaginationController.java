package tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tp.model.Admins;
import tp.model.LoginDto;
import tp.repository.AdminRepository;
import tp.repository.DetailAvionRepository;
import tp.repository.TokenAdminsRepository;
import tp.security.SafeNavigation;
import tp.model.TokenUtils;
import tp.service.CustomUserDetailsService;
import tp.service.DataResponse;

@Controller
@CrossOrigin("*")
@RequestMapping("/navigate")
public class PaginationController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TokenAdminsRepository tokenAdminsRepository;

    @Autowired
    private DetailAvionRepository detailVehiculeRepository;

    @PostMapping("/signin")
    @ResponseBody
    public ResponseEntity<DataResponse> authenticateUser(@RequestBody LoginDto dto){
        CustomUserDetailsService service = new CustomUserDetailsService();
        Admins response = service.isLocked(dto.getEmail(), dto.getMdp(), adminRepository);
        DataResponse dr = new DataResponse();

        if( response != null ){
            final TokenUtils token = SafeNavigation.encryptThisString(response);
            tokenAdminsRepository.saveAdminToken(token);
            dr.setStatus("200");
            dr.setData(token);

            return ResponseEntity.accepted().body(dr);
        }
        else{
            dr.setStatus("500");
            dr.setData("Login erronée");
            return ResponseEntity.accepted().body(dr);
        }
    }
}