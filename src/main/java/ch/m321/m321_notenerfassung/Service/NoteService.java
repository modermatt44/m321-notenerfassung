package ch.m321.m321_notenerfassung.Service;

import ch.m321.m321_notenerfassung.Dto.NoteDto;
import ch.m321.m321_notenerfassung.Model.Note;
import ch.m321.m321_notenerfassung.Model.User;
import ch.m321.m321_notenerfassung.Repository.NoteRepository;
import ch.m321.m321_notenerfassung.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing notes.
 */
@Service
public class NoteService {

 @Autowired
 private NoteRepository noteRepository;

 @Autowired
 private UserRepository userRepository;

 /**
  * Assigns a note to a user.
  *
  * @param noteId the ID of the note
  * @param userId the ID of the user
  * @return the updated note
  * @throws RuntimeException if the note or user is not found
  */
 public Note assignNoteToUser(Long noteId, Long userId) {
  Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
  User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
  note.setUser(user);
  return noteRepository.save(note);
 }

 /**
  * Creates a new note.
  *
  * @param name the name of the note
  * @param noteValue the value of the note
  * @return the created note
  */
 public Note createNote(String name, int noteValue) {
  Note note = new Note();
  note.setName(name);
  note.setNote(noteValue);
  return noteRepository.save(note);
 }

 /**
  * Deletes a note by its ID.
  *
  * @param noteId the ID of the note to delete
  */
 public void deleteNoteById(Long noteId) {
  noteRepository.deleteById(noteId);
 }
}