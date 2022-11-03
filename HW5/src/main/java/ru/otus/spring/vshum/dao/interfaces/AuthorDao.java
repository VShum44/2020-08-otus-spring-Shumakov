package ru.otus.spring.vshum.dao.interfaces;

import ru.otus.spring.vshum.domain.Author;

public interface AuthorDao {

    Author getById(int id);
}
