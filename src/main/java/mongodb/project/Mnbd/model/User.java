package mongodb.project.Mnbd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document
public class User {
    @Id
    private ObjectId id;
    private String login;
    private String password;
    private String role;
}
