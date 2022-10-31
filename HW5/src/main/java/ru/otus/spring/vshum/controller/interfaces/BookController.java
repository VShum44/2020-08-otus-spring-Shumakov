package ru.otus.spring.vshum.controller.interfaces;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.List;

public interface BookController {

    BookWrapper getBook(long id);

    long getBooksCount();

    String addBook(String title, int authorId, int genreId);

    List<BookWrapper> getAllBooks();

    String deleteBook(long bookId);
}
