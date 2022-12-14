package mongodb.project.Mnbd.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document
@Setter
@Getter
public class User {
    @Id
    public int id;
    public String login;
    public String password;
    public String role;
}
