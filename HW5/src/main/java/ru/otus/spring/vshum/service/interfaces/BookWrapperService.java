package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.wrapper.BookWrapper;

import java.util.List;


public interface BookWrapperService {

    BookWrapper mapBookToWrapper(Book book);

    List<BookWrapper> mapBooksToWrapperList(List<Book> books);
}
