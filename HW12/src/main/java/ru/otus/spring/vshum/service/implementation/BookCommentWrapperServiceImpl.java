package ru.otus.spring.vshum.service.implementation;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.service.BookCommentWrapperService;
import ru.otus.spring.vshum.service.BookService;
import ru.otus.spring.vshum.wrapper.comment.BookCommentWrapper;

@Service
public class BookCommentWrapperServiceImpl implements BookCommentWrapperService {

    private final BookService bookService;

    public BookCommentWrapperServiceImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public BookComment createBookCommentFromBookCommentWrapper(BookCommentWrapper bookCommentWrapper) {
        Book bookToAddComment = bookService.getOneById(bookCommentWrapper.getBookId());
        return new BookComment(bookCommentWrapper.getText(), bookToAddComment);
    }
}
