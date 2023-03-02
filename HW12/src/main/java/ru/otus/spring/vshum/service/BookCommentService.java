package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.wrapper.comment.BookCommentWrapper;

import java.util.List;

public interface BookCommentService {

    BookComment getOneById(long id);

    void addComment(BookCommentWrapper bookCommentWrapper);

    void updateComment(BookComment bookComment);

    List<BookComment> findAllByBookId(long bookId);

    void delete(long commentId);

}
