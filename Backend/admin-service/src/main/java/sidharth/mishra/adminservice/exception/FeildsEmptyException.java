package sidharth.mishra.adminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "feilds are empty please check")
public class FeildsEmptyException extends Exception{
}
