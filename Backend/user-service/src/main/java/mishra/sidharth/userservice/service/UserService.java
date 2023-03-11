package mishra.sidharth.userservice.service;

import mishra.sidharth.userservice.domain.User;
import mishra.sidharth.userservice.exception.FeildsEmptyException;

public interface UserService {
    User registerNewUser(User user)throws FeildsEmptyException;
   /* String loginUser(User user);*/
   /* User loginUser(User user);*/
}
