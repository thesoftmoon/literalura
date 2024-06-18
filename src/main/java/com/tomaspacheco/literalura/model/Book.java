package com.tomaspacheco.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = false)
    private String title;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authors;
    private List<String> languages;
    private Integer download_count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Book() {
    }

    //Public Constructor
    public Book(BookData bookData) {
        this.title = bookData.title();
        // here we can iterate in authordata array of authors to stream every author and add it to the db
        this.authors = bookData.authors().stream().map(authorData -> {
            Author author = new Author();
            author.setName(authorData.name());
            author.setBirth_year(authorData.birth_year());
            author.setDeath_year(authorData.death_year());
            author.setBook(this); // Establece la asociación con el libro
            return author;
        }).collect(Collectors.toList());
        this.languages = bookData.languages();
        this.download_count = bookData.download_count();
    }

    @Override
    public String toString() {
        return
                "Id: " + id +
                ", Titulo: " + title +
                ", Autores: " + authors +
                ", Lenguajes: " + languages +
                ", Numero de descargas: " + download_count;
    }
}
