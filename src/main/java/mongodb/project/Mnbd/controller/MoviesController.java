package mongodb.project.Mnbd.controller;

import com.google.gson.*;
import mongodb.project.Mnbd.repositories.MoviesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MoviesController {
    private final MoviesRepository moviesRepository;

    public MoviesController(final MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String getProductsAsList() {
        Gson gson = new Gson();

        return gson.toJson(moviesRepository.findAll());
    }

    @RequestMapping(value = "/movies/repo", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(moviesRepository.findAll());
    }
}
