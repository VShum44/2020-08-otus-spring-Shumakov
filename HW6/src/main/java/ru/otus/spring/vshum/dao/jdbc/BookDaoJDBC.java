package ru.otus.spring.vshum.dao.jdbc;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.constant.AppConst;
import ru.otus.spring.vshum.dao.interfaces.BookDao;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.domain.Book;
import ru.otus.spring.vshum.domain.Genre;

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
    public Book save(Book book) {
        Integer authorId = book.getAuthor().getId();
        Integer genreId = book.getGenre().getId();

        if(authorId == null || genreId == null) return null;

        try {
            Map<String, Object> params = Map.of("title", book.getTitle(),
                    "authorId", authorId,
                    "genreId", genreId);

            namedJdbcOperations.update("insert into books (title, author_id, genre_id)" +
                    "               values (:title, :authorId, :genreId)", params);
            return book;
        }catch (DataIntegrityViolationException e){
            System.out.println(String.format("Author id: %d or Genre id: %d doesn't exist", authorId, genreId));
            return null;
        }
    }

    @Override
    public Optional<Book> getById(long id) {
        Book book = null;

        try {
            book = namedJdbcOperations.queryForObject(
                    "select b.id as b_id," +
                            " b.title," +
                            " b.author_id," +
                            " ath.name, " +
                            " ath.patronymic," +
                            " ath.surname, " +
                            " b.genre_id, " +
                            " gen.title as g_title " +
                            "from books b " +
                            "inner join authors ath on b.author_id = ath.id " +
                            "inner join genres gen on b.genre_id = gen.id " +
                            "where b.id = :id",
                    Map.of("id", id), new BookMapper()
            );
            return Optional.ofNullable(book);

        }catch (EmptyResultDataAccessException e){
            return Optional.ofNullable(book);
        }
    }

    @Override
    public List<Book> getAll() {
        return jdbcOperations.query(
                "select b.id as b_id," +
                        " b.title," +
                        " b.author_id," +
                        " ath.name, " +
                        " ath.patronymic," +
                        " ath.surname, " +
                        " b.genre_id, " +
                        " gen.title as g_title " +
                        "from books b " +
                        "inner join authors ath on b.author_id = ath.id " +
                        "inner join genres gen on b.genre_id = gen.id ", new BookMapper());
    }

    @Override
    public int deleteById(long id) {
        return namedJdbcOperations.update("delete from books where id = :id", Map.of("id", id));
    }

    @Override
    public List<Book> getAllAuthorBooks(int authorId) {
        return namedJdbcOperations.query(
                    " select b.id as b_id, " +
                        " b.title," +
                        " b.author_id, " +
                        " ath.name, " +
                        " ath.patronymic, " +
                        " ath.surname, " +
                        " b.genre_id, " +
                        " gen.title as g_title " +
                        "from books b " +
                        "inner join authors ath on b.author_id = ath.id " +
                        "inner join genres gen on b.genre_id = gen.id " +
                                             "where author_id = :authorId",
                                              Map.of("authorId", authorId), new BookMapper());
    }

    @Override
    public List<Book> getAllBooksInCurrentGenre(int genreId) {
        return namedJdbcOperations.query(
                                         " select b.id as b_id, " +
                                                 " b.title," +
                                                 " b.author_id, " +
                                                 " ath.name, " +
                                                 " ath.patronymic, " +
                                                 " ath.surname, " +
                                                 " b.genre_id, " +
                                                 " gen.title as g_title " +
                                                 "from books b " +
                                                 "inner join authors ath on b.author_id = ath.id " +
                                                 "inner join genres gen on b.genre_id = gen.id " +
                                             "where genre_id = :genreId",
                                              Map.of("genreId", genreId), new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("b_id");
            String title = rs.getString("title");

            int authorId = rs.getInt("author_id");
            String authorName = rs.getString("name");
            String patronymic = rs.getString("patronymic");
            String surname = rs.getString("surname");

            int genreId = rs.getInt("genre_id");
            String genreTitle = rs.getString("g_title");

            return new Book(
                    id, title,
                    new Author(authorId, authorName, patronymic, surname),
                    new Genre(genreId, genreTitle)
            );
        }
    }
}
