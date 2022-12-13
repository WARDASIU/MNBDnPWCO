package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    List<Client> findAll();
    Client findByName(String name);
}