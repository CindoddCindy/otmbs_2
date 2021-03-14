package cindodcindy_otmbs_2.myOtmbs_2.repository;

import cindodcindy_otmbs_2.myOtmbs_2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
