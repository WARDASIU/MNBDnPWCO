package mongodb.project.Mnbd.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Setter
@Getter
public class Client {
    @Id
    public ObjectId _id;
    public String address;
    public String name;
    public String phone_number;
    public String surname;
    public String date_of_registration;

    public Client(final String name, final String surname, final String address, final String phone_number, final String date_of_registration) {
        this.address = address;
        this.name = name;
        this.phone_number = phone_number;
        this.surname = surname;
        this.date_of_registration = date_of_registration;
    }
}