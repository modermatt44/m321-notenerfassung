package ch.m321.m321_notenerfassung.Dto;

public class NoteDto {
    private Long id;
    private String name;
    private int note;
    private Long userId;

    public NoteDto() {
    }

    public NoteDto(Long id, String name, Long userId, int note) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public int getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
