package ru.otus.spring.vshum.dao.jpa;

import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.dao.interfaces.BookCommentDao;
import ru.otus.spring.vshum.domain.BookComment;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class BookCommentDaoJPA implements BookCommentDao {

    private final EntityManager em;

    public BookCommentDaoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<BookComment> getById(long id) {
        return Optional.ofNullable(em.find(BookComment.class, id));
    }

    @Override
    public BookComment save(BookComment comment) {
        if(comment.getId() == 0){
            em.persist(comment);
            return comment;
        }
        return em.merge(comment);
    }

    @Override
    public void delete(BookComment comment) {
        delete(comment.getId());
    }

    @Override
    public void delete(long commentId){

        BookComment comment = getById(commentId)
                .orElseThrow( () -> new NoSuchElementException("Нет комментария с таким id: " + commentId));

        em.remove(comment);
    }
}
