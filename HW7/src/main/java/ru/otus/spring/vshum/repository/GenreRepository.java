package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.vshum.domain.Genre;


public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
