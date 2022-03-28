package cz.greenrose.bookshelf.DTO;

public class SeriesDTO {
    protected Integer id;
    private String series;

    public SeriesDTO(Integer id, String series) {
        this.id = id;
        this.series = series;
    }
    public SeriesDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
