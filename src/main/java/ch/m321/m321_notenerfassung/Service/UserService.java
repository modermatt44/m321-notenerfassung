package ch.m321.m321_notenerfassung.Service;

import ch.m321.m321_notenerfassung.Model.Note;
import ch.m321.m321_notenerfassung.Model.User;
import ch.m321.m321_notenerfassung.Repository.NoteRepository;
import ch.m321.m321_notenerfassung.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing users.
 */
@Service
public class UserService {

  @Autowired
  private NoteRepository noteRepository;

  @Autowired
  private UserRepository userRepository;

  /**
   * Deletes a note from a user.
   *
   * @param noteId the ID of the note to delete
   * @return the user from whom the note was deleted
   * @throws RuntimeException if the note is not found
   */
  public User deleteNoteFromUser(Long noteId) {
    Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
    User user = note.getUser();
    note.setUser(null);
    noteRepository.save(note);
    return user;
  }
}