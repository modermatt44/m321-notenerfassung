package ch.m321.m321_notenerfassung.Repository;

import ch.m321.m321_notenerfassung.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
