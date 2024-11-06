package ch.m321.m321_notenerfassung.Dto;

/**
 * Data Transfer Object for Note.
 */
public class NoteDto {
    private String name;
    private int note;
    private Long userId;

    /**
     * Default constructor.
     */
    public NoteDto() {
    }

    /**
     * Constructor with parameters.
     *
     * @param name the name of the note
     * @param note the note value
     */
    public NoteDto(String name, int note) {
        this.name = name;
        this.note = note;
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
     * Gets the note value.
     *
     * @return the note value
     */
    public int getNote() {
        return note;
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
     * Sets the note value.
     *
     * @param note the note value
     */
    public void setNote(int note) {
        this.note = note;
    }
}