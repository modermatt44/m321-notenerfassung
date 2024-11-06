package ch.m321.m321_notenerfassung.Repository;

import ch.m321.m321_notenerfassung.Model.Note;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
  Optional<Note> findByName(String name);
}
