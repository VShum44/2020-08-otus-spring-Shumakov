package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.constant.AppConst;
import ru.otus.spring.vshum.dao.interfaces.BookDao;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.interfaces.AuthorService;
import ru.otus.spring.vshum.service.interfaces.BookService;
import ru.otus.spring.vshum.service.interfaces.BookWrapperService;
import ru.otus.spring.vshum.service.interfaces.GenreService;
import ru.otus.spring.vshum.wrapper.BookWrapper;
import ru.otus.spring.vshum.wrapper.BookWrapperToShow;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

   private final BookDao bookDao;
   private final BookWrapperService bookWrapperService;

    public BookServiceImpl(BookDao bookDao,
                           BookWrapperService bookWrapperService) {
        this.bookDao = bookDao;
        this.bookWrapperService = bookWrapperService;
    }


    @Override
    @Transactional
    public BookWrapperToShow getOneById(long id) {
        Book book = bookDao.getById(id).orElseThrow(() -> new NoSuchElementException("Нет книги с таким id: " + id));
        return bookWrapperService.createBookWrapperToShowFromBook(book);
    }

    @Override
    public long getAllBookCount() {
        return bookDao.count();
    }

    @Override
    @Transactional
    public int addNewBook(BookWrapper bookWrapper) {

        Book book = bookWrapperService.mapBookWrapperToBook(bookWrapper);
        if(bookDao.save(book) != null) return AppConst.SUCCESS;
        else return AppConst.FAIL;
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
    @Transactional
    public int deleteById(long id) {
        return bookDao.deleteById(id);
    }

    private void isDataEmpty(List<Book> books) {
        if (books.isEmpty()) throw new NoSuchElementException("Данных по данному запросу не найдено");
    }
}
