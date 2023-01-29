package ru.otus.spring.vshum.dao.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.dao.interfaces.GenreDao;
import ru.otus.spring.vshum.domain.Genre;

import javax.persistence.EntityManager;
import java.util.NoSuchElementException;
import java.util.Optional;

@Primary
@Repository
public class GenreDaoJPA implements GenreDao {

    private final EntityManager entityManager;

    public GenreDaoJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Genre> getById(int id) {
        return Optional
                .ofNullable(entityManager.find(Genre.class, id));
    }
}
