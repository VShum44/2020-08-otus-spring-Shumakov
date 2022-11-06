package ru.otus.spring.vshum.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.dao.interfaces.GenreDao;
import ru.otus.spring.vshum.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.NoSuchElementException;

@Repository
public class GenreDaoJDBC implements GenreDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public GenreDaoJDBC(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Genre getById(int id) {
        try{
            Genre genre = namedParameterJdbcOperations.queryForObject(
                    "select id, title from genres where id = :id",
                         Map.of("id",id), new GenreMapper());
            return genre;
        }catch (EmptyResultDataAccessException e){
            throw new NoSuchElementException("Heт жанра с таким id: " + id);
        }
    }

    private static class GenreMapper implements RowMapper<Genre>{

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            return new Genre(id, title);
        }
    }
}
