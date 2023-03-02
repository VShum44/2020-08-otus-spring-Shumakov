package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.domain.Genre;

import java.util.List;

public interface GenreService {

    Genre getOneById(int id);

    List<Genre> getAll();
}
