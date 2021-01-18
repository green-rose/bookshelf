package cz.greenrose.bookshelf.DTO;

public class AuthorBookshelfDTO {
    private Integer id;

    private String surname;
    private String names;
    private String wholeNames;
    private Boolean isEditor;
    private Boolean isMainAuthor;

    public AuthorBookshelfDTO(Integer id, String surname, String names, String wholeNames, Boolean isEditor,
                              Boolean isMainAuthor) {
        this.id = id;
        this.surname = surname;
        this.names = names;
        this.wholeNames = wholeNames;
        this.isEditor = isEditor;
        this.isMainAuthor = isMainAuthor;
    }

    public AuthorBookshelfDTO() {
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

    public Boolean getEditor() {
        return isEditor;
    }

    public void setEditor(Boolean editor) {
        isEditor = editor;
    }

    public Boolean getMainAuthor() {
        return isMainAuthor;
    }

    public void setMainAuthor(Boolean mainAuthor) {
        isMainAuthor = mainAuthor;
    }
}
