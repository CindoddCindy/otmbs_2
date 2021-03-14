package cindodcindy_otmbs_2.myOtmbs_2.controller;

import cindodcindy_otmbs_2.myOtmbs_2.entity.Admin;
import cindodcindy_otmbs_2.myOtmbs_2.entity.Role;
import cindodcindy_otmbs_2.myOtmbs_2.repository.AdminRepository;
import cindodcindy_otmbs_2.myOtmbs_2.repository.RoleRepository;
import cindodcindy_otmbs_2.myOtmbs_2.service.AdminService;
import cindodcindy_otmbs_2.myOtmbs_2.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AdminController {

    private AdminService adminService;
    private AdminRepository adminRepository;

    public AdminController(AdminService adminService, AdminRepository adminRepository) {
        this.adminService = adminService;
        this.adminRepository = adminRepository;
    }

    @PostMapping("/admin/create")
    public ResponseEntity<Object> createAdmin(@RequestBody Admin admin) {
        return  adminService.addAdmin(admin);
    }
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }
    @GetMapping("/admin/details/{id}")
    public Admin getAdmin(@PathVariable Long id) {
        if(adminRepository.findById(id).isPresent())
            return adminRepository.findById(id).get();
        else return null;
    }
    @GetMapping("/role/all")
    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }
}
