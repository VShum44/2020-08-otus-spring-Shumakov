package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.vshum.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
