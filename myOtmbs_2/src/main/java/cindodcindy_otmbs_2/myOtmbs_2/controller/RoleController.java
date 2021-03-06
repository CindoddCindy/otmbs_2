package cindodcindy_otmbs_2.myOtmbs_2.controller;

import cindodcindy_otmbs_2.myOtmbs_2.entity.Role;
import cindodcindy_otmbs_2.myOtmbs_2.repository.RoleRepository;
import cindodcindy_otmbs_2.myOtmbs_2.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RoleController {

    private RoleService roleService;
    private RoleRepository roleRepository;

    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return  roleService.addRole(role);
    }
    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
    @GetMapping("/role/details/{id}")
    public Role getRole(@PathVariable Long id) {
        if(roleRepository.findById(id).isPresent())
            return roleRepository.findById(id).get();
        else return null;
    }
    @GetMapping("/role/all")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
