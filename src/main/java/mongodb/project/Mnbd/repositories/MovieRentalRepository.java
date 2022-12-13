package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRentalRepository extends MongoRepository<Movies,String>{

}
