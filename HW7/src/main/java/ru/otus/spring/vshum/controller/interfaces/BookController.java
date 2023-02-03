package ru.otus.spring.vshum.controller.interfaces;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.BookWrapperToShow;

import java.util.List;

public interface BookController {

    BookWrapperToShow getBook(long id);

    long getBooksCount();

    String addBook(String title, int authorId, int genreId);

    List<Book> getAllBooks();

    String deleteBook(long bookId);

    List<Book> getAllBookInCurrentGenre(int genreId);

    List<Book> getAllAuthorBooks(int authorId);
}
