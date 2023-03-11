package sidharth.mishra.adminauthenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sidharth.mishra.adminauthenticationservice.domain.AdminAuth;

@Repository
public interface AdminAuthRepository extends JpaRepository<AdminAuth,String> {
    AdminAuth findByEmailAndPassword(String email, String password);
}
