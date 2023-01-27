package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.dao.interfaces.BookCommentDao;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.service.interfaces.BookCommentService;
import ru.otus.spring.vshum.service.interfaces.BookCommentWrapperService;
import ru.otus.spring.vshum.service.interfaces.BookService;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookCommentServiceImpl implements BookCommentService {

    private final BookService bookService;
    private final BookCommentDao bookCommentDao;
    private final BookCommentWrapperService bookCommentWrapperService;

    public BookCommentServiceImpl(BookService bookService, BookCommentDao bookCommentDao,
                                  BookCommentWrapperService bookCommentWrapperService) {
        this.bookService = bookService;
        this.bookCommentDao = bookCommentDao;
        this.bookCommentWrapperService = bookCommentWrapperService;
    }

    @Override
    public BookComment getOneById(long id) {
        return bookCommentDao.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет комментария с таким id: " + id));
    }

    @Override
    @Transactional
    public void addComment(BookCommentWrapper commentWrapper) {
        BookComment comment = bookCommentWrapperService.createBookCommentFromBookCommentWrapper(commentWrapper);
        bookCommentDao.save(comment);
    }

    @Override
    @Transactional
    public void updateComment(BookComment comment) {
        bookCommentDao.save(comment);
    }

    @Override
    @Transactional
    public List<BookComment> findAllByBookId(long bookId) {
        Book book = bookService.getOneById(bookId);
        List<BookComment> bookComments = new ArrayList<>(book.getComments());
        if(!bookComments.isEmpty()) return bookComments;
        else throw new NoSuchElementException(String.format("У книги с id: %s нет комментариев"));
    }

    @Override
    @Transactional
    public void delete(long commentId) {
        bookCommentDao.delete(commentId);
    }

}
