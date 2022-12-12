package mongodb.project.Mnbd.controller;

import lombok.extern.slf4j.Slf4j;
import mongodb.project.Mnbd.model.User;
import mongodb.project.Mnbd.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    private final UserService userService;

    public LoginController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ModelAndView login(String login, String password) {
        log.info("Login: " + login);
        log.info("Password: " + password);

        User user = userService.checkIfUserExists(login, password);
        if (user != null) {
            ModelAndView successfulModel = new ModelAndView("admin");
            successfulModel.addObject("user",user);

            return successfulModel;

        } else {
            ModelAndView errorModel = new ModelAndView();
            errorModel.setViewName("login");
            errorModel.addObject("loginError", "Incorrect username or password");

            return errorModel;
        }
    }

    @GetMapping
    public ModelAndView getLoginPage(boolean loginError) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("loginError", loginError);
        return mav;
    }

    @GetMapping("/logout")
    public String logout() {
        // Logout user
        return "redirect:/login";
    }
}
