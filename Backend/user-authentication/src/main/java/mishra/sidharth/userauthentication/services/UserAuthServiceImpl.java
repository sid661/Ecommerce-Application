package mishra.sidharth.userauthentication.services;

import mishra.sidharth.userauthentication.domain.UserAuth;
import mishra.sidharth.userauthentication.exception.EmailExitException;
import mishra.sidharth.userauthentication.exception.UserNotFoundException;
import mishra.sidharth.userauthentication.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService{

    private UserAuthRepository userAuthRepository;
    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserAuth loginData(UserAuth userAuth) throws UserNotFoundException {
        String email = userAuth.getEmail();
        String password = userAuth.getPassword();
        UserAuth detail = userAuthRepository.findByEmailAndPassword(email,password);
        if(detail == null){throw new UserNotFoundException();}
        else return detail;}

    @Override
    public String registerData(UserAuth userAuth) throws EmailExitException {
        String email = userAuth.getEmail();
        String password = userAuth.getPassword();
        UserAuth detail =userAuthRepository.findByEmailAndPassword(email,password);
        System.out.println(detail);
        if(detail!=null){throw new EmailExitException();
        }else{
            userAuthRepository.save(userAuth);
            return "New Account Created";
        }

    }
}
