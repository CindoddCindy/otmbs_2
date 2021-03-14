package cindodcindy_otmbs_2.myOtmbs_2.repository;


import cindodcindy_otmbs_2.myOtmbs_2.entity.Admin;
import cindodcindy_otmbs_2.myOtmbs_2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    Optional<Admin> findByName(String name);
}
