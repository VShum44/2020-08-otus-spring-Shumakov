package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.repository.AuthorRepository;
import ru.otus.spring.vshum.service.interfaces.AuthorService;

import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getOneById(int id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет автора с таким id: " + id));
    }
}
