package cindodcindy_otmbs_2.myOtmbs_2.service;

import cindodcindy_otmbs_2.myOtmbs_2.entity.Admin;
import cindodcindy_otmbs_2.myOtmbs_2.entity.Role;
import cindodcindy_otmbs_2.myOtmbs_2.repository.AdminRepository;
import cindodcindy_otmbs_2.myOtmbs_2.repository.RoleRepository;
import cindodcindy_otmbs_2.myOtmbs_2.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    private UserRepository userRepository;

    public AdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository =adminRepository;
        this.userRepository = userRepository;
    }

    /**
     * Create a new role along with users
     */

    @Transactional
    public ResponseEntity<Object> addAdmin(Admin admin) {

        Admin newAdmin = new Admin();
        newAdmin.setName(admin.getName());
        newAdmin.setDescription(admin.getDescription());

        newAdmin.setUsers(admin.getUsers());
        Admin savedAdmin = adminRepository.save(newAdmin);
        if (adminRepository.findById(savedAdmin.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }

    /**
     * Delete a specified role given the id
     */
    public ResponseEntity<Object> deleteAdmin(Long id) {
        if (adminRepository.findById(id).isPresent()) {
            adminRepository.deleteById(id);
            if (adminRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }
}
