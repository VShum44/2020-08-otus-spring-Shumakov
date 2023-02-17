package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.domain.Author;

import java.util.List;

public interface AuthorService {

    Author getOneById(int id);

    List<Author> getAll();
}
