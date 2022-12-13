package mongodb.project.Mnbd.controller;

import mongodb.project.Mnbd.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "/admin")
public class AdminController {
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAdminPage() {
        return new ModelAndView("admin");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addClient(String name, String surname,
                          String address, String phone) {

    }
}
