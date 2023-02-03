package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.spring.vshum.domain.Author;

@Component
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
