package ru.otus.spring.vshum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.BookSaveFormWrapperService;
import ru.otus.spring.vshum.service.BookService;
import ru.otus.spring.vshum.wrapper.book.BookSaveFormWrapper;
import ru.otus.spring.vshum.wrapper.book.BookWrapper;

import java.util.List;

@Controller
public class BookControllerImpl {

    private final BookService bookService;
    private final BookSaveFormWrapperService bookSaveFormWrapperService;

    public BookControllerImpl(BookService bookService,
                              BookSaveFormWrapperService bookSaveFormWrapperService) {
        this.bookService = bookService;
        this.bookSaveFormWrapperService = bookSaveFormWrapperService;
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

    //Хотелось бы здесь сделать PutMapping, но не понял как это реализовать в шаблоне
    @PostMapping(path = "/book/edit")
    public String editBook(BookWrapper bookWrapper){
        Book bookFromDB = bookService.getOneById(bookWrapper.getId());
        System.out.println(String.format("Book id: %s, old title: \"%s\" will be edited to new title: \"%s\"",
                bookWrapper.getId(),
                bookFromDB.getTitle(),
                bookWrapper.getTitle()));
        bookService.updateBook(bookWrapper);
        return "redirect:/";
    }

    @GetMapping(path = "book/add")
    public String addBook(Model model){
        BookSaveFormWrapper wrapper = bookSaveFormWrapperService.getSaveForm();
        model.addAttribute("wrapper", wrapper);
        return "add_new_book";
    }

    @PostMapping(path = "book/add")
    public String addBook(BookWrapper bookWrapper){
        bookService.addNewBook(bookWrapper);
        System.out.println(String.format("New book - title: \"%s\", author: %s %s, genre: %s - was added",
                bookWrapper.getTitle(),
                bookWrapper.getAuthor().getName(), bookWrapper.getAuthor().getSurname(),
                bookWrapper.getGenre().getTitle()));
        return "redirect:/";
    }

    @GetMapping(path = "/")
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "list";
    }
    // Хотел сделать DeleteMapping но в шаблоне не получается это настроить
    @PostMapping(path = "/book/delete/{id}")
    public String deleteBook(@PathVariable("id") long bookId){
        bookService.deleteById(bookId);
        System.out.println(String.format("Book with id: %s was deleted", bookId));
        return "redirect:/";
    }

    public List<Book> getAllBookInCurrentGenre(int genreId){
        return bookService.getAllBookInCurrentGenre(genreId);
    }

    public List<Book> getAllAuthorBooks(int authorId){
        return bookService.getAllAuthorBooks(authorId);
    }
}
