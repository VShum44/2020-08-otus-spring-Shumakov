package ru.otus.spring.vshum.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.vshum.constant.AppConst;
import ru.otus.spring.vshum.controller.interfaces.BookController;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.BookServiceImpl;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.List;

@ShellComponent
public class BookControllerImpl implements BookController {

    private final BookServiceImpl bookService;

    public BookControllerImpl(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @Override
    @ShellMethod(key = {"get-book", "get-b","g-b"}, value = "Get book by id")
    public Book getBook(long id){
        return bookService.getOneById(id);
    }

    @Override
    @ShellMethod(key = {"books-count", "b-c"}, value = "Get books count")
    public long getBooksCount(){
        return bookService.getAllBookCount();
    }

    @Override
    @ShellMethod(key = {"add-book", "add-b"}, value = "Add new book")
    public String addBook(String title, int authorId, int genreId){
        int result = bookService.addNewBook(new BookWrapper(title, authorId, genreId));
        return result == AppConst.SUCCESS
                ? String.format("Book with title: \"%s\" was successfully added", title)
                : String.format("Something went wrong, book \"%s\" wasn't added", title);
    }

    @Override
    @ShellMethod(key = {"all-books", "all-b"}, value = "Get all books")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @Override
    @ShellMethod(key = {"del-book", "d-b"}, value = "Delete book by id")
    public String deleteBook(long bookId){
        int result = bookService.deleteById(bookId);
        return result == AppConst.SUCCESS
                ? String.format("Book with id: %d was successfully deleted", bookId)
                : String.format("Book with id: %d doesn't exist", bookId);
    }

    @Override
    @ShellMethod(key = {"all-book-by-genre","all-b-g"}, value = "Get all book in current genre")
    public List<Book> getAllBookInCurrentGenre(int genreId){
        return bookService.getAllBookInCurrentGenre(genreId);
    }

    @Override
    @ShellMethod(key = {"all-author-books","all-a-b"}, value = "Get all book from one author")
    public List<Book> getAllAuthorBooks(int authorId){
        return bookService.getAllAuthorBooks(authorId);
    }
}
