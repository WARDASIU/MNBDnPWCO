package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.Client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    List<Client> findAll();
    Client findByNameAndSurname(String name, String surname);
    Client findBy_id(ObjectId _id);

    @Override
    <S extends Client> S save(S entity);

    void deleteByNameAndSurname(String name, String surname);
}
