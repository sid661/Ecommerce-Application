package mishra.sidharth.userauthentication.controller;

import mishra.sidharth.userauthentication.domain.UserAuth;
import mishra.sidharth.userauthentication.exception.UserNotFoundException;
import mishra.sidharth.userauthentication.services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userauth/")
public class UserAuthController {

    private UserAuthService userAuthService;
    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }
    private ResponseEntity responseEntity;

    @PostMapping("login")
    public ResponseEntity<?> userLogin(@RequestBody UserAuth userAuth)throws UserNotFoundException {
        return responseEntity = new ResponseEntity<>(userAuthService.loginData(userAuth), HttpStatus.OK);
    }
}
