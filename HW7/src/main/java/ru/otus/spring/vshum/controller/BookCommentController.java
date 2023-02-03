package ru.otus.spring.vshum.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.service.BookCommentService;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        bookCommentService.addComment(new BookCommentWrapper(text, bookId));
    }

    @ShellMethod(key = {"del-comment", "del-com"}, value = "Delete comment")
    public void deleteComment(long commentId){
        bookCommentService.delete(commentId);
        System.out.println(String.format("Комментарий с id: %s - был успешно удален", commentId));
    }

    @ShellMethod(key = {"update-com", "up-com"}, value = "Update comment")
    public void updateComment(long commentId) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BookComment bookComment = bookCommentService.getOneById(commentId);
        System.out.println(
                String.format("Меняете комментарий: \"%s\"", bookComment.getText()));
        System.out.println("Введите изменения:");
        String commentText = reader.readLine();
        bookComment.setText(commentText);
        bookCommentService.updateComment(bookComment);
    }

    @ShellMethod(key = {"all-by-book", "all-b-b"}, value = "Get all comments by book")
    public String getAllByBook(long bookId){
        return bookCommentService.findAllByBookId(bookId).toString();
    }
}
