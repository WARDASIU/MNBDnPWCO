package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends MongoRepository<Movies,String> {
    List<Movies> findAll();
}
