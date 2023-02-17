package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.wrapper.comment.BookCommentWrapper;

public interface BookCommentWrapperService {

    BookComment createBookCommentFromBookCommentWrapper(BookCommentWrapper bookCommentWrapper);
}
