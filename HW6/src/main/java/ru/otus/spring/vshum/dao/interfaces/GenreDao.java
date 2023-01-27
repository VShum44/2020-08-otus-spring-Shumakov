package ru.otus.spring.vshum.dao.interfaces;

import ru.otus.spring.vshum.domain.Genre;

import java.util.Optional;

public interface GenreDao {

    Optional<Genre> getById(int id);
}
