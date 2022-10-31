package ru.otus.spring.vshum.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.vshum.dao.interfaces.AuthorDao;
import ru.otus.spring.vshum.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.NoSuchElementException;

@Repository
public class AuthorDaoJDBC implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoJDBC(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Author getById(int id) {
        try {
             Author author = namedParameterJdbcOperations.queryForObject(
                    "select id, name, patronymic, surname " +
                        "from authors " +
                        "where id = :id ", Map.of("id",id), new AuthorMapper());
             return author;
       }catch (EmptyResultDataAccessException e){
        throw new NoSuchElementException("Heт жанра с таким id: " + id);
       }
    }


    private static class AuthorMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String patronymic = rs.getString("patronymic");
            String surname = rs.getString("surname");
            return new Author(id, name, patronymic, surname);
        }
    }
}
