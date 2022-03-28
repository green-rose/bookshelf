package cz.greenrose.bookshelf.DTO;

import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {

    protected Integer id;
    private String surname;
    private String names;
    private String wholeNames;
    public List<BookBookshelfDTO> authorBooks = new ArrayList<>();

    public AuthorDTO(Integer id, String surname, String names, String wholeNames, List<BookBookshelfDTO> authorBooks) {
        this.id = id;
        this.surname = surname;
        this.names = names;
        this.wholeNames = wholeNames;
        this.authorBooks = authorBooks;
    }

    public AuthorDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getWholeNames() {
        return wholeNames;
    }

    public void setWholeNames(String wholeNames) {
        this.wholeNames = wholeNames;
    }

    public List<BookBookshelfDTO> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(List<BookBookshelfDTO> authorBooks) {
        this.authorBooks = authorBooks;
    }
}
