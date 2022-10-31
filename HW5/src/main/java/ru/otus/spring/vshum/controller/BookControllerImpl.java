package ru.otus.spring.vshum.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.vshum.controller.interfaces.BookController;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.interfaces.BookService;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.List;

@ShellComponent
public class BookControllerImpl implements BookController {

    private final BookService bookService;
    private final int SUCCESS = 1;

    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @ShellMethod(key = {"get-book", "get-b","g-b"}, value = "Get book by id")
    public BookWrapper getBook(long id){
        return bookService.getBookWrapperById(id);
    }

    @Override
    @ShellMethod(key = {"books-count", "b-c"}, value = "Get books count")
    public long getBooksCount(){
        return bookService.getAllBookCount();
    }

    @Override
    @ShellMethod(key = {"add-book", "add-b"}, value = "Add new book")
    public String addBook(String title, int authorId, int genreId){
        int result = bookService.addNewBook(new Book(title, authorId, genreId));
        return result == SUCCESS
                ? String.format("Book with title: \"%s\" was successfully added", title)
                : String.format("Something went wrong, book \"%s\" wasn't added", title);
    }

    @Override
    @ShellMethod(key = {"all-books", "all-b"}, value = "Get all books")
    public List<BookWrapper> getAllBooks(){
        return bookService.getAll();
    }

    @Override
    @ShellMethod(key = {"del-book", "d-b"}, value = "Delete book by id")
    public String deleteBook(long bookId){
        int result = bookService.deleteById(bookId);
        return result == SUCCESS
                ? String.format("Book with id: %d was successfully deleted", bookId)
                : String.format("Book with id: %d doesn't exist", bookId);
    }

    @ShellMethod(key = {"all-book-by-genre","all-b-g"}, value = "Get all book in current genre")
    public List<BookWrapper> getAllBookInCurrentGenre(int genreId){
        return bookService.getAllBookInCurrentGenre(genreId);
    }

    @ShellMethod(key = {"all-author-books","all-a-b"}, value = "Get all book from one author")
    private List<BookWrapper> getAllAuthorBooks(int authorId){
        return bookService.getAllAuthorBooks(authorId);
    }
}
