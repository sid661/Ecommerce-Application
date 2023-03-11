package mishra.sidharth.userauthentication.repository;

import mishra.sidharth.userauthentication.domain.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth,String> {
     UserAuth findByEmailAndPassword(String email, String password);
}
