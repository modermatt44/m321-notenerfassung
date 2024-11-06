package ch.m321.m321_notenerfassung.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Entity class representing a Note.
 */
@Table(name = "note")
@Entity
public class Note {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  private String name;

  private int note;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User user;

  /**
   * Default constructor.
   */
  public Note() {
  }

  /**
   * Constructor with parameters.
   *
   * @param id the ID of the note
   * @param name the name of the note
   * @param note the note value
   */
  public Note(Long id, String name, int note) {
    this.id = id;
    this.name = name;
    this.note = note;
  }

  /**
   * Gets the ID of the note.
   *
   * @return the ID of the note
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the note.
   *
   * @param id the ID of the note
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the name of the note.
   *
   * @return the name of the note
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the note.
   *
   * @param name the name of the note
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the note value.
   *
   * @return the note value
   */
  public int getNote() {
    return note;
  }

  /**
   * Sets the note value.
   *
   * @param note the note value
   */
  public void setNote(int note) {
    this.note = note;
  }

  /**
   * Gets the user associated with the note.
   *
   * @return the user associated with the note
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets the user associated with the note.
   *
   * @param user the user associated with the note
   */
  public void setUser(User user) {
    this.user = user;
  }
}