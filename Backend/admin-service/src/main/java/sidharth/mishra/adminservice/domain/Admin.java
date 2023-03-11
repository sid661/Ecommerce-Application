package sidharth.mishra.adminservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document
public class Admin {
    @Id
    @NotBlank
    private String email;
    @NotBlank
    private String companyName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Transient
    @NotBlank
    private String password;
    private long phoneNumber;
}
