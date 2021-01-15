package cz.greenrose.bookshelf.models;

import javax.persistence.*;

@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_series", length = 11, unique = true, nullable = false, insertable = false, updatable = false)
    protected Integer id;

    private String series;

    public Series(Integer id, String series) {
        this.id = id;
        this.series = series;
    }

    public Series() {
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