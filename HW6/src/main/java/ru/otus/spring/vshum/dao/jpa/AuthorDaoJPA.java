package ru.otus.spring.vshum.dao.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.dao.interfaces.AuthorDao;
import ru.otus.spring.vshum.domain.Author;

import javax.persistence.EntityManager;
import java.util.NoSuchElementException;
import java.util.Optional;

@Primary
@Repository
public class AuthorDaoJPA implements AuthorDao {

    private final EntityManager em;

    public AuthorDaoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public Author getById(int id) {
        return Optional
                .ofNullable(em.find(Author.class, id))
                .orElseThrow(() ->  new NoSuchElementException("Нет автора с таким id"));
    }
}
