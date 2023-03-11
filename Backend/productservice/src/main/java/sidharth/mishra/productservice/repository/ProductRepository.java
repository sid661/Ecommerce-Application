package sidharth.mishra.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sidharth.mishra.productservice.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByProductName(String productName);
}
