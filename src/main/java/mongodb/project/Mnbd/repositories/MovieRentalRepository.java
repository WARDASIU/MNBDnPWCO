package mongodb.project.Mnbd.repositories;

import mongodb.project.Mnbd.model.MovieRental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRentalRepository extends MongoRepository<MovieRental,String>{
    List<MovieRental> findAll();
}
