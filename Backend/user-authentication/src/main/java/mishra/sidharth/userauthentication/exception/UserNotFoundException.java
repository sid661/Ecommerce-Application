package mishra.sidharth.userauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "LOGIN Failed Please Check Login ID and Password")
public class UserNotFoundException extends Exception{
}
