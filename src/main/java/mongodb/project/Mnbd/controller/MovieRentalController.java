package mongodb.project.Mnbd.controller;

import com.google.gson.Gson;
import mongodb.project.Mnbd.GsonUtils;
import mongodb.project.Mnbd.repositories.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRentalController {
    @Autowired
    private MovieRentalRepository movieRentalRepository;

    @GetMapping(value = "/admin/movies/currentRentals")
    public String getMoviesRental() {
        Gson gson = GsonUtils.getGson();

        return gson.toJson(movieRentalRepository.findAll());
    }
}
