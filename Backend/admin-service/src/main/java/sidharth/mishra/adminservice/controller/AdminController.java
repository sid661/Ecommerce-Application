package sidharth.mishra.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sidharth.mishra.adminservice.domain.Admin;
import sidharth.mishra.adminservice.exception.FeildsEmptyException;
import sidharth.mishra.adminservice.service.AdminService;

import javax.validation.Valid;

@RestController
@RequestMapping("admin/")
public class AdminController {

    private AdminService adminService;
    private ResponseEntity responseEntity;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid Admin admin)throws FeildsEmptyException {
      return responseEntity = new ResponseEntity<>(adminService.registeradmin(admin), HttpStatus.CREATED);
    }
}
