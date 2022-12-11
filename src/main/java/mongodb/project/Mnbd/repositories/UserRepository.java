package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<Users, String> {
    List<Users> findAll();
    List<Users> findById(final ObjectId id);

    Users findByLoginAndPassword(String login, String password);
    Users findByLogin(String login);
}
