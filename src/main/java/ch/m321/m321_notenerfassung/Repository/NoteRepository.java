package ch.m321.m321_notenerfassung.Repository;

import ch.m321.m321_notenerfassung.Model.Note;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for Note entity.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

  /**
   * Finds a note by its name.
   *
   * @param name the name of the note
   * @return an Optional containing the found note, or empty if not found
   */
  Optional<Note> findByName(String name);
}