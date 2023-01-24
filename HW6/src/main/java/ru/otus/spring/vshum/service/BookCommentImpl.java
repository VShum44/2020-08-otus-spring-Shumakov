package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.dao.interfaces.BookCommentDao;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.service.interfaces.BookCommentService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookCommentImpl implements BookCommentService {

    private final BookCommentDao bookCommentDao;

    public BookCommentImpl(BookCommentDao bookCommentDao) {
        this.bookCommentDao = bookCommentDao;
    }

    @Override
    public BookComment getOneById(long id) {
        return bookCommentDao.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет комментария с таким id: " + id));
    }

    @Override
    @Transactional
    public void addComment(BookComment comment) {
        bookCommentDao.addComment(comment);
    }

    @Override
    public List<BookComment> findAllByBookId(long bookId) {
        return bookCommentDao.getAllByBookId(bookId);
    }
}
