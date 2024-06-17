package com.tomaspacheco.literalura.repository;

import com.tomaspacheco.literalura.model.Book;
import com.tomaspacheco.literalura.model.BookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
