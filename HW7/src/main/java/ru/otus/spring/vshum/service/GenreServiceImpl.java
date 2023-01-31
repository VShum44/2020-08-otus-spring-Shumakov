package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Genre;
import ru.otus.spring.vshum.repository.GenreRepository;
import ru.otus.spring.vshum.service.interfaces.GenreService;

import java.util.NoSuchElementException;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre getOneById(int id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет жанра с таким id: " + id));
    }
}
