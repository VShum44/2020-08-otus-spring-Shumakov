package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

import java.util.List;

public interface BookCommentService {

    BookComment getOneById(long id);

    void addComment(BookCommentWrapper bookCommentWrapper);

    void updateComment(BookComment bookComment);

    List<BookComment> findAllByBookId(long bookId);

    void delete(long commentId);

}
