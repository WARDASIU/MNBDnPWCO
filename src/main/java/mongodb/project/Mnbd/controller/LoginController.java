package mongodb.project.Mnbd.controller;

import mongodb.project.Mnbd.model.Users;
import mongodb.project.Mnbd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public LoginController(final UserRepository userRepository, final AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public String submitLoginForm(Model model, String login, String password) {
        // Query the database for a user with the given username and password
        Users user = userRepository.findByLoginAndPassword(login, password);

        // If the user exists, authenticate them
        if (user != null) {
            // Create an authentication token
            Authentication token = new UsernamePasswordAuthenticationToken(
                    user.getLogin(),
                    user.getPassword());

            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(token);

            // Set the authentication in the security context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Add the user to the model
            model.addAttribute("user", authentication.getPrincipal());
        }

        // Redirect to the dashboard
        return "redirect:/dashboard";
    }

    @GetMapping
    public ModelAndView getLoginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        List<Users> usersList = userRepository.findAll();
        mav.addObject("login", usersList);

        return mav;
    }
}
