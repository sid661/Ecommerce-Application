package sidharth.mishra.productservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Images {

    @Id
    private long imageId;
    private String name;
    private String type;

    private byte[] picByte;

    public Images(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
