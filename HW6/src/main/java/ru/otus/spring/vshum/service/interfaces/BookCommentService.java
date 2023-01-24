package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.BookComment;

import java.util.List;

public interface BookCommentService {

    BookComment getOneById(long id);

    void addComment(BookComment bookComment);

    List<BookComment> findAllByBookId(long bookId);

}
