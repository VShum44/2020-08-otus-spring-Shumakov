package ru.otus.spring.vshum.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.service.interfaces.BookCommentService;

@ShellComponent
public class BookCommentController {

    private final BookCommentService bookCommentService;

    public BookCommentController(BookCommentService bookCommentService) {
        this.bookCommentService = bookCommentService;
    }

    @ShellMethod(key = {"get-comment", "get-com","g-com"}, value = "Get book_comment by id")
    public String getComment(long id){
        return bookCommentService.getOneById(id).getText();
    }

    @ShellMethod(key = {"add-comment", "add-com"}, value = "Add comment to book")
    public void addComment(String text, long bookId){
        bookCommentService.addComment(new BookComment(text, bookId));
    }

}
