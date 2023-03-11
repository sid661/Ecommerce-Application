package sidharth.mishra.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sidharth.mishra.productservice.domain.Product;
import sidharth.mishra.productservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }

    public String deleteProduct(String productId){

        productRepository.deleteById(productId);
        return "delted";
    }

    public Product updateProduct(Product product){
        Optional<Product> productcheck = productRepository.findById(product.getProductId());
        if(productcheck.isPresent()){
            Product productupdate = productcheck.get();
            productupdate.setProductId(product.getProductId());
            productupdate.setProductName(product.getProductName());
            productupdate.setCost(product.getCost());
            return productRepository.save(productupdate);
        }else return null;

    }
   public Product findProduct(String productName){
       return productRepository.findByProductName(productName);

   }

public List<Product> findAllProduct(){
       return productRepository.findAll();
}
}
