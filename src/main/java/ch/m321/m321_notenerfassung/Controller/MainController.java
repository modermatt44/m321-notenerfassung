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

/**
 * Main controller for handling requests related to notes and users.
 */
@RestController
public class MainController {

  @Autowired
  private NoteService noteService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  /**
   * Endpoint to return a greeting message.
   *
   * @return a greeting message
   */
  @GetMapping("/")
  public String index() {
    return "Hello World!";
  }

  /**
   * Endpoint to assign a note to a user.
   *
   * @param noteId the ID of the note
   * @param userId the ID of the user
   * @return the updated note
   */
  @PostMapping("/assignNoteToUser")
  public Note assignNoteToUser(@RequestParam Long noteId, @RequestParam Long userId) {
    return noteService.assignNoteToUser(noteId, userId);
  }

  /**
   * Endpoint to retrieve all users.
   *
   * @return a list of all users
   */
  @GetMapping("/getUsers")
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  /**
   * Endpoint to delete a note from a user.
   *
   * @param noteId the ID of the note
   * @param userId the ID of the user
   */
  @DeleteMapping("/deleteNoteFromUser")
  public void deleteNoteFromUser(@RequestParam Long noteId, @RequestParam Long userId) {
    userService.deleteNoteFromUser(noteId);
  }

  /**
   * Endpoint to create a new note.
   *
   * @param noteDto the data transfer object containing note details
   * @return the created note
   */
  @PostMapping("/createNote")
  public Note createNote(@RequestBody NoteDto noteDto) {
    return noteService.createNote(noteDto.getName(), noteDto.getNote());
  }

  /**
   * Endpoint to delete a note by its ID.
   *
   * @param noteId the ID of the note to be deleted
   */
  @DeleteMapping("/deleteNote")
  public void deleteNote(@RequestParam Long noteId) {
    noteService.deleteNoteById(noteId);
  }
}