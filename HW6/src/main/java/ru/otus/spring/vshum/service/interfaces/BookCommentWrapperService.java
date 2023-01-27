package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.domain.BookComment;
import ru.otus.spring.vshum.wrapper.BookCommentWrapper;

import javax.xml.stream.events.Comment;

public interface BookCommentWrapperService {

    BookComment createBookCommentFromBookCommentWrapper(BookCommentWrapper bookCommentWrapper);
}
