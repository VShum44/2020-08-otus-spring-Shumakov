package ru.otus.spring.vshum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.spring.vshum.constant.AppConst;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.implementation.BookServiceImpl;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.List;

@Controller
public class BookControllerImpl {

    private final BookServiceImpl bookService;

    public BookControllerImpl(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/book/{id}")
    public String getBook(@PathVariable long id){

        return bookService.showBook(id).toString();
    }

    public long getBooksCount(){
        return bookService.getAllBookCount();
    }


    public String addBook(String title, int authorId, int genreId){
        int result = bookService.addNewBook(new BookWrapper(title, authorId, genreId));
        return result == AppConst.SUCCESS
                ? String.format("Book with title: \"%s\" was successfully added", title)
                : String.format("Something went wrong, book \"%s\" wasn't added", title);
    }


    public List<Book> getAllBooks(){
        return bookService.getAll();
    }


    public String deleteBook(long bookId){
        bookService.deleteById(bookId);
        return String.format("Book with id: %d was successfully deleted", bookId);
    }

    public List<Book> getAllBookInCurrentGenre(int genreId){
        return bookService.getAllBookInCurrentGenre(genreId);
    }

    public List<Book> getAllAuthorBooks(int authorId){
        return bookService.getAllAuthorBooks(authorId);
    }
}
