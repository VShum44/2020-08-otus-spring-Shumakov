package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.Genre;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByGenre(Genre genre);

    List<Book> findAllByAuthor(Author author);
}
