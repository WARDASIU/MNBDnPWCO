package mongodb.project.Mnbd.service;

import mongodb.project.Mnbd.model.User;
import mongodb.project.Mnbd.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User checkIfUserExists(String login, String password){
        return userRepository.findByLoginAndPassword(login, password);
    }

    public User loadUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public boolean verifyPassword(String password, User user) {
        return password.equals(user.getPassword());
    }
}