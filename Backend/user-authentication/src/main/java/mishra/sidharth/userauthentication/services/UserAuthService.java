package mishra.sidharth.userauthentication.services;

import mishra.sidharth.userauthentication.domain.UserAuth;
import mishra.sidharth.userauthentication.exception.EmailExitException;
import mishra.sidharth.userauthentication.exception.UserNotFoundException;

public interface UserAuthService {
    String registerData(UserAuth userAuth)throws EmailExitException;
    UserAuth loginData(UserAuth userAuth) throws UserNotFoundException;


}
