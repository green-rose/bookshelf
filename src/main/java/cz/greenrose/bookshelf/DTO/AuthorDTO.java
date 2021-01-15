package cz.greenrose.bookshelf.DTO;

public class AuthorDTO {
    private Long id;
    private String surname;
    private String names;

    public AuthorDTO(Long id, String surname, String names) {
        this.id = id;
        this.surname = surname;
        this.names = names;
    }

    public AuthorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}
