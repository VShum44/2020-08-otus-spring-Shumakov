package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

public interface BookCommentWrapperService {

    BookComment createBookCommentFromBookCommentWrapper(BookCommentWrapper bookCommentWrapper);
}
