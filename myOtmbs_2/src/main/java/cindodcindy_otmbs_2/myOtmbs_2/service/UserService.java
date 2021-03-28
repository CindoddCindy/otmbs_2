package cindodcindy_otmbs_2.myOtmbs_2.service;


import cindodcindy_otmbs_2.myOtmbs_2.entity.Role;
import cindodcindy_otmbs_2.myOtmbs_2.entity.User;
import cindodcindy_otmbs_2.myOtmbs_2.repository.RoleRepository;
import cindodcindy_otmbs_2.myOtmbs_2.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    public UserService( UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    /**
     * Create a new role along with users
     */

    @Transactional
    public ResponseEntity<Object> addUser(User user) {

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setMobile(user.getMobile());

        user.setRole(user.getRole());
        User savedUser = userRepository.save(newUser);
        if (userRepository.findById(savedUser.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }

    /**
     * Delete a specified role given the id
     */
    public ResponseEntity<Object> deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            if (userRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }
}
