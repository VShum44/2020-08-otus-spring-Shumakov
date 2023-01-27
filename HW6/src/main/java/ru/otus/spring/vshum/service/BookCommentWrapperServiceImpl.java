package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.service.interfaces.BookCommentWrapperService;
import ru.otus.spring.vshum.service.interfaces.BookService;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

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
