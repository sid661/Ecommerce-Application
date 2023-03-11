package sidharth.mishra.productservice.service;

import org.springframework.stereotype.Component;
import sidharth.mishra.productservice.domain.Product;

import java.util.List;


public interface ProductService {
    Product addNewProduct(Product product);

    String deleteProduct(String productId);

    Product updateProduct(Product product);

    Product findProduct(String productName);

    List<Product> findAllProduct();
}