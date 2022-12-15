package mongodb.project.Mnbd.controller;

import lombok.extern.slf4j.Slf4j;
import mongodb.project.Mnbd.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
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
        UserDetails user = userService.loadUserByUsername(login);
        if (user != null) {
            if (userService.verifyPassword(password, user)) {
                ModelAndView successfulModel = new ModelAndView();
                successfulModel.setViewName("redirect:/admin");
                successfulModel.addObject("user", user);
                return successfulModel;
            } else {
                return getLoginPage(true);
            }
        } else return getLoginPage(true);
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
        return "redirect:/login";
    }
}
