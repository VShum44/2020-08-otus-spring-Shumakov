package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
