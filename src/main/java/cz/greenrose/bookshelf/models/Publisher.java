package cz.greenrose.bookshelf.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publisher",length=11, unique = true, nullable = false, insertable = false, updatable = false)
    protected Integer id;

    private String publisher;

    @OneToMany(mappedBy = "publisher")
    public List<Book> booksOfPublisher = new ArrayList<>();

    public Publisher(Integer id, String publisher) {
        this.id = id;
        this.publisher = publisher;
    }

    public Publisher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
