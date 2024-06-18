package com.tomaspacheco.literalura.repository;

import com.tomaspacheco.literalura.model.Author;
import com.tomaspacheco.literalura.model.Book;
import com.tomaspacheco.literalura.model.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY b.id ASC")
    List<Book> getAllBooks();

    @Query("SELECT a FROM Author a ORDER BY a.id ASC")
    List<Author> getAllAuthors();

    @Query("SELECT a FROM Author a WHERE a.birth_year <= :isAliveYear AND (a.death_year >= :isAliveYear)")
    List<Author> getAllAuthorsAliveInDeterminedYear(Integer isAliveYear);

    @Query(value = "SELECT * FROM books WHERE :language = ANY (languages)", nativeQuery = true)
    List<Book> findByLanguage(String language);


}
