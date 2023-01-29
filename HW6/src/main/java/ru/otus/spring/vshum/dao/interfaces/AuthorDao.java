package ru.otus.spring.vshum.dao.interfaces;

import ru.otus.spring.vshum.domain.Author;

import java.util.Optional;

public interface AuthorDao {

    Optional<Author> getById(int id);
}
