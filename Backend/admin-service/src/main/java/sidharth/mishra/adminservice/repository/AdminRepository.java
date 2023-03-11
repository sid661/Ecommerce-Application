package sidharth.mishra.adminservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sidharth.mishra.adminservice.domain.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin,String> {
Admin findByEmailAndPassword(String email, String Password);
}
