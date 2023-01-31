package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.BookWrapper;
import ru.otus.spring.vshum.wrapper.BookWrapperToShow;

public interface BookWrapperService {

    Book mapBookWrapperToBook(BookWrapper bookWrapper);

    BookWrapperToShow createBookWrapperToShowFromBook(Book book);

}
