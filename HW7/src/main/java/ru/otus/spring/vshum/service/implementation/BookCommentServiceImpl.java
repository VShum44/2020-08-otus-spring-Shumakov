package ru.otus.spring.vshum.service.implementation;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.repository.BookCommentRepository;
import ru.otus.spring.vshum.service.BookCommentService;
import ru.otus.spring.vshum.service.BookCommentWrapperService;
import ru.otus.spring.vshum.service.BookService;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookCommentServiceImpl implements BookCommentService {

    private final BookService bookService;
    private final BookCommentRepository repository;
    private final BookCommentWrapperService bookCommentWrapperService;

    public BookCommentServiceImpl(BookService bookService,
                                  BookCommentRepository repository,
                                  BookCommentWrapperService bookCommentWrapperService) {
        this.bookService = bookService;
        this.repository = repository;
        this.bookCommentWrapperService = bookCommentWrapperService;
    }

    @Override
    public BookComment getOneById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет комментария с таким id: " + id));
    }

    @Override
    public void addComment(BookCommentWrapper commentWrapper) {
        BookComment comment = bookCommentWrapperService.createBookCommentFromBookCommentWrapper(commentWrapper);
        repository.save(comment);
    }

    @Override
    public void updateComment(BookComment comment) {
        repository.save(comment);
    }

    @Override
    public List<BookComment> findAllByBookId(long bookId) {
        Book book = bookService.getOneById(bookId);
        List<BookComment> bookComments = new ArrayList<>(book.getComments());

        if(bookComments.isEmpty()){
            throw new NoSuchElementException(String.format("У книги с id: %s нет комментариев", bookId));
        }
        else {
            return bookComments;
        }
    }

    @Override
    public void delete(long commentId) {
        repository.deleteById(commentId);
    }

}
