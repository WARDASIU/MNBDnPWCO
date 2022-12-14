package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();

    User findByLogin(String login);
}
