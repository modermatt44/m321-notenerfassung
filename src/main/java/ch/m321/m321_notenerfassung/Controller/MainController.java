package ch.m321.m321_notenerfassung.Controller;

import ch.m321.m321_notenerfassung.Dto.NoteDto;
import ch.m321.m321_notenerfassung.Model.Note;
import ch.m321.m321_notenerfassung.Model.User;
import ch.m321.m321_notenerfassung.Repository.UserRepository;
import ch.m321.m321_notenerfassung.Service.NoteService;
import ch.m321.m321_notenerfassung.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

  @Autowired
  private NoteService noteService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String index() {
    return "Hello World!";
  }

  @PostMapping("/assignNoteToUser")
  public Note assignNoteToUser(@RequestParam Long noteId, @RequestParam Long userId) {
    return noteService.assignNoteToUser(noteId, userId);
  }

  @GetMapping("/getUsers")
  public List<User> getUsers() {
      return userRepository.findAll();
  }

  @DeleteMapping("/deleteNoteFromUser")
  public void deleteNoteFromUser(@RequestParam Long noteId, @RequestParam Long userId) {
      userService.deleteNoteFromUser(noteId);
  }

  @PostMapping("/createNote")
  public Note createNote(@RequestBody NoteDto noteDto) {
      return noteService.createNote(noteDto.getName(), noteDto.getNote());
  }

  @DeleteMapping("/deleteNote")
  public void deleteNote(@RequestParam Long noteId) {
      noteService.deleteNoteById(noteId);
  }
}
