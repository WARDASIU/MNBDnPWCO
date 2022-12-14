package mongodb.project.Mnbd.controller;

import lombok.extern.slf4j.Slf4j;
import mongodb.project.Mnbd.model.Client;
import mongodb.project.Mnbd.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private ClientRepository clientRepository;

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

    @GetMapping("/clients")
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok().body(clientRepository.findAll());
    }
}
