package ru.otus.spring.vshum.dao.jpa;

import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.constant.AppConst;
import ru.otus.spring.vshum.dao.interfaces.BookDao;
import ru.otus.spring.vshum.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        TypedQuery<Book> query = em.createQuery("select b from Book b ", Book.class);
        return query.getResultList();
    }

    @Override
    public int deleteById(long id) {
        Book book = getById(id)
                .orElseThrow(() -> new NoSuchElementException("Нет книги с таким id: " + id));
        em.remove(book);

        return AppConst.SUCCESS;
    }

    @Override
    public List<Book> getAllAuthorBooks(int authorId) {
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "where b.author.id = :authorId", Book.class);
        query.setParameter("authorId", authorId);
        return query.getResultList();
    }

    @Override
    public List<Book> getAllBooksInCurrentGenre(int genreId) {
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "where b.genre.id = :genreId", Book.class);
        query.setParameter("genreId", genreId);
        return query.getResultList();
    }
}
