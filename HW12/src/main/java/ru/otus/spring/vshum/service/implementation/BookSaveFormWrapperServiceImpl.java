package ru.otus.spring.vshum.service.implementation;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.service.AuthorService;
import ru.otus.spring.vshum.service.BookSaveFormWrapperService;
import ru.otus.spring.vshum.service.GenreService;
import ru.otus.spring.vshum.wrapper.book.BookSaveFormWrapper;

import java.util.ArrayList;

@Service
public class BookSaveFormWrapperServiceImpl implements BookSaveFormWrapperService {

    private final GenreService genreService;
    private final AuthorService authorService;

    public BookSaveFormWrapperServiceImpl(GenreService genreService, AuthorService authorService) {
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @Override
    public BookSaveFormWrapper getSaveForm() {
        return new BookSaveFormWrapper(new ArrayList<>(genreService.getAll()),
                new ArrayList<>(authorService.getAll()));
    }
}
