package ru.otus.spring.vshum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.spring.vshum.constant.AppConst;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.BookService;
import ru.otus.spring.vshum.wrapper.BookWrapper;
import ru.otus.spring.vshum.wrapper.BookWrapperFromForm;

import java.util.List;

@Controller
public class BookControllerImpl {

    private final BookService bookService;

    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/book/{id}")
    public String getBook(@PathVariable long id, Model model){
        Book book = bookService.getOneById(id);
        model.addAttribute("book", book);
        return "card_book";
    }

    @GetMapping(path = "/book/edit")
    public String editBook(@RequestParam("id") long id, Model model){
        Book book = bookService.getOneById(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping(path = "/book/edit")
    public String editBook(BookWrapperFromForm bookWrapper){
        System.out.println("PostEdit");
        bookService.updateBook(bookWrapper);
        return "redirect:/";
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

    @GetMapping(path = "/")
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "list";
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
