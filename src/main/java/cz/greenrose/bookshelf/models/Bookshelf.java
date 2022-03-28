package cz.greenrose.bookshelf.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Bookshelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bookshelf",length=11, unique = true, nullable = false, insertable = false, updatable = false)
    protected Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id_book",referencedColumnName="id_book")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id_author",referencedColumnName="id_author")
    private Author author;

    @Column(name = "is_editor")
    private Boolean isEditor;

    @Column(name = "is_main_author")
    private Boolean isMainAuthor;

    public Bookshelf(Integer id, Book book, Author author, Boolean isEditor, Boolean isMainAuthor) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.isEditor = isEditor;
        this.isMainAuthor = isMainAuthor;
    }

    public Bookshelf() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
