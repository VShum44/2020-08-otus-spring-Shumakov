package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.List;

public interface BookService {

    Book getOneById(long id);

    BookWrapper getBookWrapperById(long id);

    long getAllBookCount();

    int addNewBook(Book book);

    List<BookWrapper> getAll();

    List<BookWrapper> getAllBookInCurrentGenre(int genreId);

    List<BookWrapper> getAllAuthorBooks(int authorId);

    int deleteById(long id);
}
