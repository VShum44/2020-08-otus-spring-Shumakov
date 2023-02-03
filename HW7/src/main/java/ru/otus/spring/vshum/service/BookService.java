package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.BookWrapper;
import ru.otus.spring.vshum.wrapper.BookWrapperToShow;

import java.util.List;

public interface BookService {

    BookWrapperToShow showBook(long id);

    Book getOneById(long id);

    long getAllBookCount();

    int addNewBook(BookWrapper bookWrapper);

    List<Book> getAll();

    List<Book> getAllBookInCurrentGenre(int genreId);

    List<Book> getAllAuthorBooks(int authorId);

    void deleteById(long id);
}
