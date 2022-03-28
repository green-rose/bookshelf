package cz.greenrose.bookshelf.DTO;

public class BookBookshelfDTO {
    private Integer bookId;
    private String bookTitle;
    private Boolean isEditor;
    private Boolean isMainAuthor;

    public BookBookshelfDTO(Integer bookId, String bookTitle, Boolean isEditor, Boolean isMainAuthor) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.isEditor = isEditor;
        this.isMainAuthor = isMainAuthor;
    }
    public BookBookshelfDTO() {
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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
