package mongodb.project.Mnbd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mongodb.project.Mnbd.repositories.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@AllArgsConstructor
@Data
@Document
@Setter
@Getter
public class MovieRental {
    @Autowired
    private final MovieRentalRepository movieRentalRepository;

    @RequestMapping(value = "/movies/rental", method = RequestMethod.GET)
    public ModelAndView getProductsAsList() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("movies");
        List<Movies> moviesList = movieRentalRepository.findAll();
        mav.addObject("movies", moviesList);

        return mav;
    }
}
