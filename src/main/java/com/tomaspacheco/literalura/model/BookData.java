package com.tomaspacheco.literalura.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.OneToMany;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("id") Integer book_id,
        String title,
        List<AuthorData> authors,
        List<String> languages,
        Integer download_count
) {
}
