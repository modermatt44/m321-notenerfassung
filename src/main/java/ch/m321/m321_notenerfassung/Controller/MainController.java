package ch.m321.m321_notenerfassung.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
  @GetMapping("/")
  public String index() {
    return "Hello World!";
  }

  @GetMapping("/assignNoteToUser")
  public String assignNoteToUser() {
    return "Note "  + " assigned to user " ;
  }
}
