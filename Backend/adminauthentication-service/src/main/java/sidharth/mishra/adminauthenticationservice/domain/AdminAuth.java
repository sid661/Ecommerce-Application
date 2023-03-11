package sidharth.mishra.adminauthenticationservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Admin_Login_Data")
public class AdminAuth {

    @NotBlank
    @Id
    private String email;
    @NotBlank
    private String companyName;
    @NotBlank
    private String password;

}
