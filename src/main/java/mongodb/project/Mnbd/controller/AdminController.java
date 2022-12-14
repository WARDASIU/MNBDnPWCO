package mongodb.project.Mnbd.controller;

import lombok.extern.slf4j.Slf4j;
import mongodb.project.Mnbd.model.Client;
import mongodb.project.Mnbd.model.MovieRental;
import mongodb.project.Mnbd.model.Movies;
import mongodb.project.Mnbd.repositories.ClientRepository;
import mongodb.project.Mnbd.repositories.MovieRentalRepository;
import mongodb.project.Mnbd.repositories.MoviesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private MovieRentalRepository movieRentalRepository;

    @GetMapping
    public ModelAndView getAdminPage(String response, String result) {
        ModelAndView mav = new ModelAndView("admin");
        if (response != null && result != null) {
            mav.addObject(response, result);
        }

        return mav;
    }

    @PostMapping
    public ModelAndView addClient(String name, String surname,
                                  String address, String phone) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        clientRepository.save(new Client(name, surname, address, phone, dateFormat.format(date)));

        return getAdminPage("clientCreated", "Client created!");
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteClient(String nameToDelete, String surnameToDelete) {
        if (clientRepository.findByNameAndSurname(nameToDelete, surnameToDelete) != null) {
            clientRepository.deleteByNameAndSurname(nameToDelete, surnameToDelete);

            return getAdminPage("clientDeleted", "Client deleted!");
        }
        return getAdminPage("clientNotFound", "Client not found!");
    }

    @PostMapping(value = "/update")
    public ModelAndView updateClient(@RequestParam ObjectId idToUpdate, String nameToUpdate, String surnameToUpdate) {
        log.info(String.valueOf(idToUpdate));
        Client client = clientRepository.findBy_id(idToUpdate);
        if (client != null) {
            client.setName(nameToUpdate);
            client.setSurname(surnameToUpdate);
            clientRepository.save(client);

            return getAdminPage("clientCreatedOrUpdated", "");
        }
        return getAdminPage("clientNotFoundOnUpdate", "Client not found!");
    }

    @PostMapping("/addMovie")
    public ModelAndView addMovie(String addCategory, String addRating,
                                 String addDirector, String addPlot,
                                 String addTitle, String addActors,
                                 String addYear) {
        List<String> actors = List.of(addActors.split(","));
        moviesRepository.save(new Movies(addCategory, Integer.parseInt(addRating),
                addDirector, addPlot, addTitle, actors, Integer.parseInt(addYear)));


        return getAdminPage("movieAdded", "Movie added!");
    }

    @PostMapping(value = "/deleteMovie")
    public ModelAndView deleteMovie(int movieIdToDelete) {
        if (moviesRepository.findBy_id(movieIdToDelete) != null) {
            moviesRepository.deleteBy_id(movieIdToDelete);

            return getAdminPage("MovieDeleted", "Movie deleted!");
        }
        return getAdminPage("MovieNotFound", "Movie not found!");
    }

    @PostMapping(value = "/rentMovie")
    public ModelAndView rentMovie(@RequestParam ObjectId clientsIdToRent, int movieToRent) {
//        TimeZone tz = TimeZone.getTimeZone("UTC");
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
//        df.setTimeZone(tz);
//        String nowAsISO = df.format(new Date());

        // Get the current datetime
        LocalDateTime now = LocalDateTime.now();

// Add two days to the current datetime
        LocalDateTime twoDaysLater = now.plusDays(2);

// Format the datetime as an ISO string
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
        String isoString = twoDaysLater.format(isoFormatter);

        Client client = clientRepository.findBy_id(clientsIdToRent);
        Movies movie = moviesRepository.findBy_id(movieToRent);
        if (client != null) {
            if (movie != null) {
                movieRentalRepository.save(new MovieRental(client, movie.getTitle(), now.format(isoFormatter), twoDaysLater.format(isoFormatter)));

                return getAdminPage("MovieRented", "Movie rented!");
            }
            return getAdminPage("ClientToRentNotFound", "Client not found!");
        }
        return getAdminPage("MovieToRentNotFound", "Movie not found!");
    }
}