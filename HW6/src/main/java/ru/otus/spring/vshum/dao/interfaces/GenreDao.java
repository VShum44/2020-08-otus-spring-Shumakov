package ru.otus.spring.vshum.dao.interfaces;

import ru.otus.spring.vshum.domain.Genre;

public interface GenreDao {

    Genre getById(int id);
}
