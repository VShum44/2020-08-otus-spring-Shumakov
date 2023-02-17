package ru.otus.spring.vshum.service.implementation;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.constant.AppConst;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.Genre;
import ru.otus.spring.vshum.repository.BookRepository;
import ru.otus.spring.vshum.service.AuthorService;
import ru.otus.spring.vshum.service.BookService;
import ru.otus.spring.vshum.service.BookWrapperService;
import ru.otus.spring.vshum.service.GenreService;
import ru.otus.spring.vshum.wrapper.book.BookWrapper;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

   private final GenreService genreService;
   private final AuthorService authorService;
   private final BookRepository bookRepository;
   private final BookWrapperService bookWrapperService;

    public BookServiceImpl(GenreService genreService,
                           AuthorService authorService,
                           BookRepository bookRepository,
                           BookWrapperService bookWrapperService) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookRepository = bookRepository;
        this.bookWrapperService = bookWrapperService;
    }

    @Override
    public Book getOneById(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет книги с таким id: " + id));
    }

    @Override
    public long getAllBookCount() {
        return bookRepository.count();
    }

    @Override
    public int addNewBook(BookWrapper bookWrapper) {

        Book book = bookWrapperService.mapBookWrapperToBook(bookWrapper);
        if(bookRepository.save(book) != null) return AppConst.SUCCESS;
        else return AppConst.FAIL;
    }

    //В книге разрешено менять только название
    @Override
    public void updateBook(BookWrapper bookWrapper) {
        Book bookToEdit = bookRepository.findById(bookWrapper.getId())
                .orElseThrow(() -> new NoSuchElementException("Нет книги с таким id:" + bookWrapper.getId()));
        bookToEdit.setTitle(bookWrapper.getTitle());
        bookRepository.save(bookToEdit);
    }

    @Override
    public List<Book> getAll() {

        List<Book> books = bookRepository.findAll();

        isDataEmpty(books);

        return books;
    }

    @Override
    public List<Book> getAllBookInCurrentGenre(int genreId) {

        Genre genre = genreService.getOneById(genreId);

        List<Book> books = bookRepository.findAllByGenre(genre);

        isDataEmpty(books);

        return books;
    }

    @Override
    public List<Book> getAllAuthorBooks(int authorId) {

        Author author = authorService.getOneById(authorId);

        List<Book> books = bookRepository.findAllByAuthor(author);

        isDataEmpty(books);

        return books;
    }

    @Override
    public void deleteById(long id) {
         bookRepository.deleteById(id);
    }

    private void isDataEmpty(List<Book> books) {
        if (books.isEmpty()) throw new NoSuchElementException("Данных по данному запросу не найдено");
    }
}
