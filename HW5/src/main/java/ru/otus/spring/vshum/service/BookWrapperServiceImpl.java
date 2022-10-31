package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.interfaces.AuthorService;
import ru.otus.spring.vshum.service.interfaces.BookWrapperService;
import ru.otus.spring.vshum.service.interfaces.GenreService;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookWrapperServiceImpl implements BookWrapperService {

    private final GenreService genreService;
    private final AuthorService authorService;

    public BookWrapperServiceImpl(GenreService genreService, AuthorService authorService) {
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @Override
    public BookWrapper mapBookToWrapper(Book book) {
        return new BookWrapper(book.getId(),
                book.getTitle(),
                authorService.getOneById(book.getAuthorId()),
                genreService.getOneById(book.getGenreId()));
    }

    public List<BookWrapper> mapBooksToWrapperList(List<Book> books) {
        List<BookWrapper> bookWrapperList = new ArrayList<>();

        for (Book book : books) {
            BookWrapper bookWrapper = mapBookToWrapper(book);
            bookWrapperList.add(bookWrapper);
        }
        return bookWrapperList;
    }
}
