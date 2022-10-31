package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.dao.interfaces.GenreDao;
import ru.otus.spring.vshum.domain.Genre;
import ru.otus.spring.vshum.service.interfaces.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public Genre getOneById(int id) {
        return genreDao.getById(id);
    }
}
