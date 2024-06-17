package com.tomaspacheco.literalura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer book_id;
    @Column(unique = false)
    private String title;
    /*@OneToMany(mappedBy = "authors")
    private List<AuthorData> authors;*/
    private List<String> languages;
    private Integer download_count;
}
