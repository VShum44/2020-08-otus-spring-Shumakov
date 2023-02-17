package ru.otus.spring.vshum.service.implementation;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.service.AuthorService;
import ru.otus.spring.vshum.service.BookWrapperService;
import ru.otus.spring.vshum.service.GenreService;
import ru.otus.spring.vshum.wrapper.book.BookWrapper;

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
                authorService.getOneById(bookWrapper.getAuthor().getId()),
                genreService.getOneById(bookWrapper.getGenre().getId())
        );
    }
}
