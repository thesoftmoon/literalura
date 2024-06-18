package com.tomaspacheco.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksData(
        Integer count,
        List<BookData> results
) {
    public List<BookData> getResults() {
        return results;
    }

    /*public void setResults(List<BookData> results) {
        this.results = results;
    }*/
}
