package sidharth.mishra.adminservice.service;

import sidharth.mishra.adminservice.domain.Admin;
import sidharth.mishra.adminservice.exception.AdminNotFoundException;
import sidharth.mishra.adminservice.exception.FeildsEmptyException;

public interface AdminService {
    Admin registeradmin(Admin admin)throws FeildsEmptyException;
    Admin loginAdmin(Admin admin) throws AdminNotFoundException;
}
