package mishra.sidharth.userauthentication.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="User_Login_Data")
public class UserAuth {
    @Id
    private String email;
    private String password;
}
