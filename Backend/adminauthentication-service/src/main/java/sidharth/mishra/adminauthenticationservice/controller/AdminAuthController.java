package sidharth.mishra.adminauthenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sidharth.mishra.adminauthenticationservice.domain.AdminAuth;
import sidharth.mishra.adminauthenticationservice.exception.AdminNotFound;
import sidharth.mishra.adminauthenticationservice.service.AdminAuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("AdminAuthentication/")
public class AdminAuthController {

    private AdminAuthService adminAuthService;
    private ResponseEntity responseEntity;
    @Autowired
    public AdminAuthController(AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    @PostMapping("login")
    public ResponseEntity<?> adminLogin(@RequestBody @Valid AdminAuth adminAuth)throws AdminNotFound {

        return responseEntity = new ResponseEntity(adminAuthService.adminLogin(adminAuth), HttpStatus.CREATED);
    }
}
