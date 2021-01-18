package cz.greenrose.bookshelf.DTO;

public class PublisherDTO {
    private Integer id;
    private String publisher;

    public PublisherDTO(Integer id, String publisher) {
        this.id = id;
        this.publisher = publisher;
    }

    public PublisherDTO() {
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
