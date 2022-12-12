package mongodb.project.Mnbd.controller;

import mongodb.project.Mnbd.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdminPage(@ModelAttribute("user") User user){
        return new ModelAndView("admin");
    }
}
