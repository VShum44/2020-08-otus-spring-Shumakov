package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.book.BookWrapper;

public interface BookWrapperService {

    Book mapBookWrapperToBook(BookWrapper bookWrapper);
}

