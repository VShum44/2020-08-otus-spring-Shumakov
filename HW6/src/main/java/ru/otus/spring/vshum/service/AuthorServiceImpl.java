package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.dao.interfaces.AuthorDao;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.service.interfaces.AuthorService;

import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getOneById(int id) {
        return authorDao.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет автора с таким id: " + id));
    }
}
