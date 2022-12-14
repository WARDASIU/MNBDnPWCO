package mongodb.project.Mnbd.controller;

import lombok.extern.slf4j.Slf4j;
import mongodb.project.Mnbd.model.Client;
import mongodb.project.Mnbd.model.Movies;
import mongodb.project.Mnbd.repositories.ClientRepository;
import mongodb.project.Mnbd.repositories.MoviesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MoviesRepository moviesRepository;

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
    public ModelAndView deleteMovie(String movieIdToDelete) {
        if (moviesRepository.findBy_id(Integer.parseInt(movieIdToDelete)) != null) {
            moviesRepository.deleteBy_id(Integer.parseInt(movieIdToDelete));

            return getAdminPage("MovieDeleted", "Movie deleted!");
        }
        return getAdminPage("MovieNotFound", "Movie not found!");
    }
}