package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.interfaces.AuthorService;
import ru.otus.spring.vshum.service.interfaces.BookWrapperService;
import ru.otus.spring.vshum.service.interfaces.GenreService;
import ru.otus.spring.vshum.wrapper.BookWrapper;

@Service
public class BookWrapperServiceImpl implements BookWrapperService {

    private final GenreService genreService;
    private final AuthorService authorService;

    public BookWrapperServiceImpl(GenreService genreService,
                                  AuthorService authorService) {
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @Override
    public Book mapBookWrapperToBook(BookWrapper bookWrapper) {

        return new Book(
                bookWrapper.getTitle(),
                authorService.getOneById(bookWrapper.getAuthorId()),
                genreService.getOneById(bookWrapper.getGenreId())
        );
    }
}
