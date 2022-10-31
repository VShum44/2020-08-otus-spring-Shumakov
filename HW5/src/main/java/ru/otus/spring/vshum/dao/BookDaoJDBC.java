package ru.otus.spring.vshum.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.dao.interfaces.BookDao;
import ru.otus.spring.vshum.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookDaoJDBC implements BookDao {

    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedJdbcOperations;

    public BookDaoJDBC(JdbcOperations jdbcOperations,
                       NamedParameterJdbcOperations namedJdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.namedJdbcOperations = namedJdbcOperations;
    }

    @Override
    public long count() {
        Long count = jdbcOperations.queryForObject(
                "select count(*) from books ",
                     Long.class);

        return count == null? 0: count;
    }

    @Override
    public int add(Book book) {
        Map<String, Object> params = Map.of("title", book.getTitle(),
                                            "authorId", book.getAuthorId(),
                                            "genreId", book.getGenreId());

        return namedJdbcOperations.update("insert into books (title, author_id, genre_id)" +
                        "               values (:title, :authorId, :genreId)", params);
    }

    @Override
    public Optional<Book> getById(long id) {
        Book book = null;

        try {
            book = namedJdbcOperations.queryForObject(
                    "select id, title, author_id, genre_id " +
                        "from books " +
                        "where id = :id",
                         Map.of("id", id), new BookMapper()
            );
            return Optional.ofNullable(book);

        }catch (EmptyResultDataAccessException e){
            return Optional.ofNullable(book);
        }
    }

    @Override
    public List<Book> getAll() {
        return jdbcOperations.query("select id, title, author_id, genre_id from books", new BookMapper());
    }

    @Override
    public int deleteById(long id) {
        return namedJdbcOperations.update("delete from books where id = :id", Map.of("id", id));
    }

    @Override
    public List<Book> getAllAuthorBooks(int authorId) {
        return namedJdbcOperations.query("select id, title, author_id, genre_id " +
                                             "from books " +
                                             "where author_id = :authorId",
                                              Map.of("authorId", authorId), new BookMapper());
    }

    @Override
    public List<Book> getAllBooksInCurrentGenre(int genreId) {
        return namedJdbcOperations.query("select id, title, author_id, genre_id " +
                                             "from books " +
                                             "where genre_id = :genreId",
                                              Map.of("genreId", genreId), new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String title = rs.getString("title");
            int authorId = rs.getInt("author_id");
            int genreId = rs.getInt("genre_id");
            return new Book(id, title, authorId, genreId);
        }
    }
}
