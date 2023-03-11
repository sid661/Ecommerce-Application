package mishra.sidharth.userservice.requestmodel;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class RequestModel {
    private String email;
    private String password;
}
