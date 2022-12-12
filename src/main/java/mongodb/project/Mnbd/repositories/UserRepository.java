package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();

    User findByLogin(String login);
    User findByLoginAndPassword(String login, String password);
}
