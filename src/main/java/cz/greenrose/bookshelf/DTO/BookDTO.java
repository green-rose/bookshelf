package cz.greenrose.bookshelf.DTO;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {
    public Integer bookId;
    public String bookTitle;
    public List<AuthorBookauthorDTO> bookAuthors = new ArrayList<>();
    private Integer editionNumber;
    private Integer year;
    private PublisherDTO publisher;
    private SeriesDTO series;
    private Integer episodeNumber;
    private String language;

    public BookDTO() {
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

    public List<AuthorBookauthorDTO> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<AuthorBookauthorDTO> bookAuthors) {
        this.bookAuthors = bookAuthors;
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

    public PublisherDTO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDTO publisher) {
        this.publisher = publisher;
    }

    public SeriesDTO getSeries() {
        return series;
    }

    public void setSeries(SeriesDTO series) {
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
