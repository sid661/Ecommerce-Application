package sidharth.mishra.productservice.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Document
@Data
public class Product {
    @Id
    @NotBlank
    private String productId;
    @NotBlank
    private String productName;
    @NotBlank
    private String cost;

    private Set<Images> productImages;
}
