package mongodb.project.Mnbd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document
@Setter
@Getter
public class Client {
    @Id
    public int _id;
    public String address;
    public String name;
    public String phone_number;
    public String surname;
    public String date_of_registration;
}
