package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.vshum.domain.BookComment;


public interface BookCommentRepository extends JpaRepository<BookComment, Long> {
}
