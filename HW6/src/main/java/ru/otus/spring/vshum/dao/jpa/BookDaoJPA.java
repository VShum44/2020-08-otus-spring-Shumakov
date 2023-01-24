package ru.otus.spring.vshum.dao.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.dao.interfaces.BookDao;
import ru.otus.spring.vshum.domain.Book;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class BookDaoJPA implements BookDao {

    private final EntityManager em;

    public BookDaoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public long count() {
        Query query = em.createQuery("select count(b) from Book b");
        return (long) query.getSingleResult();
    }

    @Override
    public Book save(Book book) {
        if(book.getId() <= 0) {
            em.persist(book);
            return book;
        }
        return em.merge(book);
    }

    @Override
    public Optional<Book> getById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public List<Book> getAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("book_author_genre_and_comments_graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b ", Book.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

    @Override
    public int deleteById(long id) {
        Query query = em.createQuery("delete from Book b where b.id = :id ");
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    @Override
    public List<Book> getAllAuthorBooks(int authorId) {
        EntityGraph<?> entityGraph = em.getEntityGraph("book_author_genre_and_comments_graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "where b.author.id = :authorId", Book.class);
        query.setParameter("authorId", authorId);
        query.setHint("javax.persistence.fetchgraph",entityGraph);
        return query.getResultList();
    }

    @Override
    public List<Book> getAllBooksInCurrentGenre(int genreId) {
        EntityGraph<?> entityGraph = em.getEntityGraph("book_author_genre_and_comments_graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "where b.genre.id = :genreId", Book.class);
        query.setParameter("genreId", genreId);
        query.setHint("javax.persistence.fetchgraph",entityGraph);
        return query.getResultList();
    }
}
