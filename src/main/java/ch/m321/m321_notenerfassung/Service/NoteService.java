package ch.m321.m321_notenerfassung.Service;

import ch.m321.m321_notenerfassung.Dto.NoteDto;
import ch.m321.m321_notenerfassung.Model.Note;
import ch.m321.m321_notenerfassung.Model.User;
import ch.m321.m321_notenerfassung.Repository.NoteRepository;
import ch.m321.m321_notenerfassung.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

  @Autowired
  private NoteRepository noteRepository;

  @Autowired
  private UserRepository userRepository;

  public Note assignNoteToUser(Long noteId, Long userId) {
    Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    note.setUser(user);
    return noteRepository.save(note);
  }

  public Note createNote(String name, int noteValue) {
      Note note = new Note();
      note.setName(name);
      note.setNote(noteValue);
      return noteRepository.save(note);
  }

   public void deleteNoteById(Long noteId) {
       noteRepository.deleteById(noteId);
   }

}
