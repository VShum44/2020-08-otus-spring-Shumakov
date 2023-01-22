package ru.otus.spring.vshum.dao.interfaces;

import ru.otus.spring.vshum.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    long count();

    Book save(Book book);

    Optional<Book> getById(long id);

    List<Book> getAll();

    int deleteById(long id);

    List<Book> getAllAuthorBooks(int authorId);

    List<Book> getAllBooksInCurrentGenre(int genreId);
}
