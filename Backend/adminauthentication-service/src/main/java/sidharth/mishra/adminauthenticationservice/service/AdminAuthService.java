package sidharth.mishra.adminauthenticationservice.service;

import sidharth.mishra.adminauthenticationservice.domain.AdminAuth;
import sidharth.mishra.adminauthenticationservice.exception.AdminNotFound;

public interface AdminAuthService {
    public AdminAuth saveAdmin(AdminAuth adminAuth);
    public AdminAuth adminLogin(AdminAuth adminAuth) throws AdminNotFound;
}
