package ch.m321.m321_notenerfassung.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for serving JavaDoc.
 */
@Controller
public class JavaDocController {

 /**
  * Maps the /doc endpoint to the JavaDoc index page.
  *
  * @return the path to the JavaDoc index page
  */
 @GetMapping("/doc")
 public String getJavaDoc() {
  return "redirect:/javadoc/index.html";
 }
}