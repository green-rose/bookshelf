package cz.greenrose.bookshelf.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book",length=11, unique = true, nullable = false, insertable = false, updatable = false)
    protected Integer id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "edition_no")
    private Integer editionNumber;

    @Column(length=4)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "Publisher_id_publisher",referencedColumnName="id_publisher")
    @JsonBackReference
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "Series_id_series",referencedColumnName="id_series")
    @JsonBackReference
    private Series series;

    @Column(name = "episode_no")
    private Integer episodeNumber;

    private String language;

    @OneToMany(mappedBy = "book")
    public List<Bookauthor> authorsOfBook = new ArrayList<>();


    public Book(Integer id, String bookTitle, Integer editionNumber, Integer year, Publisher publisher, Series series, Integer episodeNumber, String language) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.editionNumber = editionNumber;
        this.year = year;
        this.publisher = publisher;
        this.series = series;
        this.episodeNumber = episodeNumber;
        this.language = language;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Integer getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(Integer editionNumber) {
        this.editionNumber = editionNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
