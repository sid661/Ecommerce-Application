package mishra.sidharth.userauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = " Emaild ID exists")
public class EmailExitException extends Exception{
}
