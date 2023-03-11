package mishra.sidharth.userservice.controller;

import mishra.sidharth.userservice.domain.User;
import mishra.sidharth.userservice.exception.FeildsEmptyException;
import mishra.sidharth.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user/")
public class UserController {

    private UserService userService;
    private ResponseEntity responseEntity;
   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid User user)throws FeildsEmptyException {
       return responseEntity = new ResponseEntity<>(userService.registerNewUser(user), HttpStatus.CREATED);
    }
 /*   @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
       return responseEntity = new ResponseEntity<>(userService.loginUser(user),HttpStatus.FOUND);
    }*/
}
