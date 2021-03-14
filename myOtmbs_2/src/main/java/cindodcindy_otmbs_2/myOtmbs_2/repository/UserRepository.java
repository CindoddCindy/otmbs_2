package cindodcindy_otmbs_2.myOtmbs_2.repository;

import cindodcindy_otmbs_2.myOtmbs_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
