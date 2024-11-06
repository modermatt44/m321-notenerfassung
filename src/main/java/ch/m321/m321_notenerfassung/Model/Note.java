package ch.m321.m321_notenerfassung.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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

  public Note() {
  }

  public Note(Long id, String name, int note) {
    this.id = id;
    this.name = name;
    this.note = note;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNote() {
    return note;
  }

  public void setNote(int note) {
    this.note = note;
  }
}
