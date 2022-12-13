package mongodb.project.Mnbd.controller;

import com.google.gson.Gson;
import mongodb.project.Mnbd.model.Movies;
import mongodb.project.Mnbd.repositories.MoviesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
    private final MoviesRepository moviesRepository;

    public MoviesController(final MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

//    @RequestMapping(value = "/movies", method = RequestMethod.GET)
//    public ModelAndView getProductsAsList() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("movies");
//        List<Movies> moviesList = moviesRepository.findAll();
//        mav.addObject("movies", moviesList);
//
//        return mav;
//    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String getProductsAsList() {
        Gson gson = new Gson();
        String json = gson.toJson(moviesRepository.findAll());
        List<Movies> moviesList = moviesRepository.findAll();

        return json;
    }

    @RequestMapping(value = "/movies/repo", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(moviesRepository.findAll());
    }
}
