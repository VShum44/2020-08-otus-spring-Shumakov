package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.book.BookWrapper;

import java.util.List;

public interface BookService {

    Book getOneById(long id);

    long getAllBookCount();

    int addNewBook(BookWrapper bookWrapper);

    void updateBook(BookWrapper bookWrapper);

    List<Book> getAll();

    List<Book> getAllBookInCurrentGenre(int genreId);

    List<Book> getAllAuthorBooks(int authorId);

    void deleteById(long id);
}
