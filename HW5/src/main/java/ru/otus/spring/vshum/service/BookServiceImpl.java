package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.dao.interfaces.BookDao;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.interfaces.BookService;
import ru.otus.spring.vshum.service.interfaces.BookWrapperService;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

   private final BookDao bookDao;
   private final BookWrapperService bookWrapperService;

    public BookServiceImpl(BookDao bookDao, BookWrapperService bookWrapperService) {
        this.bookDao = bookDao;
        this.bookWrapperService = bookWrapperService;
    }


    @Override
    public Book getOneById(long id) {
        return bookDao.getById(id).orElseThrow(() -> new NoSuchElementException("Нет книги с таким id: " + id));
    }

    @Override
    public long getAllBookCount() {
        return bookDao.count();
    }

    @Override
    public int addNewBook(BookWrapper bookWrapper) {
        Book book = bookWrapperService.mapBookWrapperToBook(bookWrapper);

        return bookDao.add(book);
    }

    @Override
    public List<Book> getAll() {

        List<Book> books = bookDao.getAll();

        isDataEmpty(books);

        return books;
    }

    @Override
    public List<Book> getAllBookInCurrentGenre(int genreId) {

        List<Book> books = bookDao.getAllBooksInCurrentGenre(genreId);

        isDataEmpty(books);

        return books;
    }

    @Override
    public List<Book> getAllAuthorBooks(int authorId) {

        List<Book> books = bookDao.getAllAuthorBooks(authorId);

        isDataEmpty(books);

        return books;
    }

    @Override
    public int deleteById(long id) {
        return bookDao.deleteById(id);
    }

    private void isDataEmpty(List<Book> books) {
        if (books.isEmpty()) throw new NoSuchElementException("Данных по данному запросу не найдено");
    }
}
