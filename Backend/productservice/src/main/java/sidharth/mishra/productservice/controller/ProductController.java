package sidharth.mishra.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sidharth.mishra.productservice.domain.Images;
import sidharth.mishra.productservice.domain.Product;
import sidharth.mishra.productservice.service.ProductService;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("product/")
public class ProductController {
    private ResponseEntity responseEntity;
    @Autowired
    private ProductService productService;


    @PostMapping(value = {"add"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addProduct(@RequestPart("product")Product product,
                                        @RequestPart("image")MultipartFile[] file)
    {
       // return responseEntity = new ResponseEntity(productService.addNewProduct(product), HttpStatus.CREATED);
        try{
            Set<Images> image=uploadImage(file);
            product.setProductImages(image);
          return  productService.addNewProduct(product);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<Images> uploadImage(MultipartFile[] multipartFile) throws IOException {
        Set<Images> imagesSet= new HashSet<>();
        for(MultipartFile file:multipartFile){
            Images images = new Images(file.getOriginalFilename(),file.getContentType(),file.getBytes());
            imagesSet.add(images);
        }
           return imagesSet;
    }



    @DeleteMapping("delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable String productId){
        return responseEntity=new ResponseEntity(productService.deleteProduct(productId),HttpStatus.OK);

    }

    @PutMapping("update")
    public ResponseEntity<?> updateProduct(@RequestBody @Valid Product product){
        return responseEntity = new ResponseEntity(productService.updateProduct(product),HttpStatus.OK);
    }
    @GetMapping("all")
    public ResponseEntity<?> allProduct(){
        return responseEntity = new ResponseEntity(productService.findAllProduct(),HttpStatus.OK);
    }
    @GetMapping("findproduct/{productName}")
    public ResponseEntity<?> findProduct(@PathVariable String productName){
        return responseEntity = new ResponseEntity(productService.findProduct(productName),HttpStatus.FOUND);
    }
}
