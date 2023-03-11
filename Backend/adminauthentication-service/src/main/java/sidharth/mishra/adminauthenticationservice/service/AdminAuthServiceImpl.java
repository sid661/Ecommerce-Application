package sidharth.mishra.adminauthenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sidharth.mishra.adminauthenticationservice.domain.AdminAuth;
import sidharth.mishra.adminauthenticationservice.exception.AdminNotFound;
import sidharth.mishra.adminauthenticationservice.repository.AdminAuthRepository;
@Component
public class AdminAuthServiceImpl implements AdminAuthService{
    @Autowired
    private AdminAuthRepository adminAuthRepository;

    public AdminAuth saveAdmin(AdminAuth adminAuth){
        return adminAuthRepository.save(adminAuth);

    }

    public AdminAuth adminLogin(AdminAuth adminAuth) throws AdminNotFound {
        String email= adminAuth.getEmail();
        String password= adminAuth.getPassword();
        AdminAuth check= adminAuthRepository.findByEmailAndPassword(email,password);
          if(check==null){
              throw  new AdminNotFound();
          }
       else return check;
    }
}
