package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import main.java.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class AuthorDAOImpl implements AuthorDAO {

    private JdbcTemplate jdbcTemplate;

    public AuthorDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Author author) {
        if (author.getId() > 0) {
            // update
            String sql = "UPDATE author SET birth=?, firstName=?, lastName=?";
            jdbcTemplate.update(sql, author.getBirth(), author.getFirstName(),
                    author.getLastName());
        } else {
            // insert
            String sql = "INSERT INTO author (birth, firstName, lastName)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, author.getBirth(), author.getFirstName(),
                    author.getLastName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM author WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Author> list() {
        String sql = "SELECT * FROM author";
        List<Author> listAuthor = jdbcTemplate.query(sql, new RowMapper<Author>() {

            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                Author aAuthor = new Author();

                aAuthor.setId(rs.getInt("id"));
                aAuthor.setBirth(rs.getInt("birth"));
                aAuthor.setFirstName(rs.getString("firstName"));
                aAuthor.setLastName(rs.getString("lastName"));

                return aAuthor;
            }

        });

        return listAuthor;
    }

    @Override
    public Author get(int id) {
        String sql = "SELECT * FROM author WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Author>() {

            @Override
            public Author extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setBirth(rs.getInt("birth"));
                    author.setFirstName(rs.getString("firstName"));
                    author.setLastName(rs.getString("lastName"));
                    return author;
                }

                return null;
            }

        });
    }

}
