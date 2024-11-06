package ch.m321.m321_notenerfassung.Repository;

import ch.m321.m321_notenerfassung.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Finds a user by their email.
   *
   * @param email the email of the user
   * @return an Optional containing the found user, or empty if not found
   */
  Optional<User> findByEmail(String email);
}