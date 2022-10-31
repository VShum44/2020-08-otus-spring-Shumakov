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

   private final BookWrapperService bookWrapperService;
   private final BookDao bookDao;

    public BookServiceImpl(BookWrapperService bookWrapperService,
                           BookDao bookDao) {
        this.bookWrapperService = bookWrapperService;
        this.bookDao = bookDao;
    }


    @Override
    public Book getOneById(long id) {
        return bookDao.getById(id).orElseThrow(() -> new NoSuchElementException("Нет книги с таким id: " + id));
    }

    @Override
    public BookWrapper getBookWrapperById(long id){
        Optional<Book> book = bookDao.getById(id);

        BookWrapper bookWrapper = bookWrapperService.mapBookToWrapper(book.
                orElseThrow( () -> new NoSuchElementException("Нет книги с таким id: " + id))
        );

        return bookWrapper;
    }

    @Override
    public long getAllBookCount() {
        return bookDao.count();
    }

    @Override
    public int addNewBook(Book book) {
        return bookDao.add(book);
    }

    @Override
    public List<BookWrapper> getAll() {

        List<Book> books = bookDao.getAll();

        isDataEmpty(books);

        return bookWrapperService.mapBooksToWrapperList(books);
    }

    @Override
    public List<BookWrapper> getAllBookInCurrentGenre(int genreId) {

        List<Book> books = bookDao.getAllBooksInCurrentGenre(genreId);

        isDataEmpty(books);

        return bookWrapperService.mapBooksToWrapperList(books);
    }

    @Override
    public List<BookWrapper> getAllAuthorBooks(int authorId) {

        List<Book> books = bookDao.getAllAuthorBooks(authorId);

        isDataEmpty(books);

        return bookWrapperService.mapBooksToWrapperList(books);
    }

    @Override
    public int deleteById(long id) {
        return bookDao.deleteById(id);
    }

    private void isDataEmpty(List<Book> books) {
        if (books.isEmpty()) throw new NoSuchElementException("Данных по данному запросу не найдено");
    }
}
