package cz.greenrose.bookshelf.models;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author",length=11, unique = true, nullable = false, insertable = false, updatable = false)
    protected Integer id;

    private String surname;
    private String names;
    @Column(name = "whole_name")
    private String wholeNames;

    public Author(Integer id, String surname, String names, String wholeNames) {
        this.id = id;
        this.surname = surname;
        this.names = names;
        this.wholeNames = wholeNames;
    }

    public Author() {
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
}
