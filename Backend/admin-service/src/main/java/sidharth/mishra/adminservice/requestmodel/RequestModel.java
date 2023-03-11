package sidharth.mishra.adminservice.requestmodel;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
@Document
@Data
public class RequestModel {
    @Id
    @NotBlank
    private String email;
    @NotBlank
    private String companyName;
    @NotBlank
    private String password;
}
