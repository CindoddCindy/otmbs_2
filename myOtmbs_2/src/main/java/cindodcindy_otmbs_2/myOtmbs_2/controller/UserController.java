package cindodcindy_otmbs_2.myOtmbs_2.controller;

import cindodcindy_otmbs_2.myOtmbs_2.entity.User;
import cindodcindy_otmbs_2.myOtmbs_2.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/details/{id}")
    public User getUser(@PathVariable Long id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return null;
    }

    @GetMapping("/user/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
