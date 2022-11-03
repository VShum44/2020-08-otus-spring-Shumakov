package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.List;

public interface BookService {

    Book getOneById(long id);

    long getAllBookCount();

    int addNewBook(BookWrapper bookWrapper);

    List<Book> getAll();

    List<Book> getAllBookInCurrentGenre(int genreId);

    List<Book> getAllAuthorBooks(int authorId);

    int deleteById(long id);
}
