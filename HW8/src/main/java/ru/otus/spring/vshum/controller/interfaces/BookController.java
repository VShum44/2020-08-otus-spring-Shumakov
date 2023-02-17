package ru.otus.spring.vshum.controller.interfaces;
import ru.otus.spring.vshum.domain.Book;

import java.util.List;

public interface BookController {

    long getBooksCount();

    String addBook(String title, int authorId, int genreId);

    List<Book> getAllBooks();

    String deleteBook(long bookId);

    List<Book> getAllBookInCurrentGenre(int genreId);

    List<Book> getAllAuthorBooks(int authorId);
}
