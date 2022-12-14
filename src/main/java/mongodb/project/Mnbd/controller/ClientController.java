package mongodb.project.Mnbd.controller;

import com.google.gson.Gson;
import mongodb.project.Mnbd.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/admin/clients")
    public String getProductsAsList() {
        Gson gson = new Gson();

        return gson.toJson(clientRepository.findAll());
    }

    @GetMapping("admin/clients/entity")
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok().body(clientRepository.findAll());
    }

}