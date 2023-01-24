package ru.otus.spring.vshum.dao.interfaces;

import ru.otus.spring.vshum.domain.BookComment;

import java.util.List;
import java.util.Optional;

public interface BookCommentDao {

    Optional<BookComment> getById(long id);

    BookComment save(BookComment comment);

    List<BookComment> getAllByBookId(long bookId);

    void delete(BookComment comment);

    void delete(long id);

}
