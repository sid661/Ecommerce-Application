package mishra.sidharth.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PARTIAL_CONTENT,reason = "feilds are empty please check")
public class FeildsEmptyException extends Exception {
}
