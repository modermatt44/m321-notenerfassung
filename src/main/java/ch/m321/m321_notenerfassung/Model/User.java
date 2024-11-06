package ch.m321.m321_notenerfassung.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Table(name = "user")
@Entity
public class User {
  /**
   * The user ID.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  /**
   * The full name.
   */
  @Column(nullable = false)
  private String fullName;

  /**
   * The email address.
   */
  @Column(unique = true, length = 100, nullable = false)
  private String email;

  /**
   * The note id.
   */
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Note> notes;

  /**
   * The creation timestamp.
   */
  @CreationTimestamp
  @Column(updatable = false, name = "created_at")
  private Date createdAt;

  /**
   * The update timestamp.
   */
  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;

  /**
   * Gets the username (email).
   *
   * @return the email
   */
  public String getUsername() {
    return email;
  }

  /**
   * Checks if the account is non-expired.
   *
   * @return true if the account is non-expired, false otherwise
   */
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * Checks if the account is non-locked.
   *
   * @return true if the account is non-locked, false otherwise
   */
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * Checks if the credentials are non-expired.
   *
   * @return true if the credentials are non-expired, false otherwise
   */
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * Checks if the account is enabled.
   *
   * @return true if the account is enabled, false otherwise
   */
  public boolean isEnabled() {
    return true;
  }

  /**
   * Gets the user ID.
   *
   * @return the user ID
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the user ID.
   *
   * @param id the user ID to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the full name.
   *
   * @return the full name
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Sets the full name.
   *
   * @param fullName the full name to set
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the creation timestamp.
   *
   * @return the creation timestamp
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the creation timestamp.
   *
   * @param createdAt the creation timestamp to set
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets the update timestamp.
   *
   * @return the update timestamp
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Sets the update timestamp.
   *
   * @param updatedAt the update timestamp to set
   */
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

    /**
     * Gets the notes.
     *
     * @return the notes
     */
    public List<Note> getNotes() {
      return notes;
    }

    /**
     * Sets the notes.
     *
     * @param notes the notes to set
     */
    public void setNotes(List<Note> notes) {
      this.notes = notes;
    }

    /**
     * Adds a note.
     *
     * @param note the note to add
     */
    public void addNote(Note note) {
      notes.add(note);
      note.setUser(this);
    }

    /**
     * Removes a note.
     *
     * @param note the note to remove
     */
    public void removeNote(Note note) {
      notes.remove(note);
      note.setUser(null);
    }
}