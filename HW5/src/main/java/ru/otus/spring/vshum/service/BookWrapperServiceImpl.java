package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.Genre;
import ru.otus.spring.vshum.service.interfaces.BookWrapperService;
import ru.otus.spring.vshum.wrapper.BookWrapper;

@Service
public class BookWrapperServiceImpl implements BookWrapperService {

    @Override
    public Book mapBookWrapperToBook(BookWrapper bookWrapper) {

        return new Book(
                bookWrapper.getTitle(),
                new Author(bookWrapper.getAuthorId()),
                new Genre(bookWrapper.getGenreId())
        );
    }
}
