package ru.otus.spring.vshum.controller;

import org.springframework.stereotype.Controller;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.service.BookCommentService;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class BookCommentController {

    private final BookCommentService bookCommentService;

    public BookCommentController(BookCommentService bookCommentService) {
        this.bookCommentService = bookCommentService;
    }

    public String getComment(long id){
        return bookCommentService.getOneById(id).getText();
    }

    public void addComment(String text, long bookId){
        bookCommentService.addComment(new BookCommentWrapper(text, bookId));
    }

    public void deleteComment(long commentId){
        bookCommentService.delete(commentId);
        System.out.println(String.format("Комментарий с id: %s - был успешно удален", commentId));
    }

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


    public String getAllByBook(long bookId){
        return bookCommentService.findAllByBookId(bookId).toString();
    }
}
