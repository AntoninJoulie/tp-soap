package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import main.java.model.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class BookDAOImpl implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    public BookDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Book book) {
        if (book.getId() > 0) {
            // update
            String sql = "UPDATE book SET title=?, isbn=?, publishYear=?";
            jdbcTemplate.update(sql, book.getTitle(), book.getIsbn(),
                    book.getPublishYear());
        } else {
            // insert
            String sql = "INSERT INTO book (title, isbn, publishYear)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, book.getTitle(), book.getIsbn(),
                    book.getPublishYear());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM book WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Book> list() {
        String sql = "SELECT * FROM book";
        List<Book> listBook = jdbcTemplate.query(sql, new RowMapper<Book>() {

            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book aBook = new Book();

                aBook.setId(rs.getInt("id"));
                aBook.setTitle(rs.getString("title"));
                aBook.setIsbn(rs.getInt("isbn"));
                aBook.setPublishYear(rs.getInt("publishYear"));

                return aBook;
            }

        });

        return listBook;
    }

    @Override
    public Book get(int id) {
        String sql = "SELECT * FROM book WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Book>() {

            @Override
            public Book extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setTitle(rs.getString("title"));
                    book.setIsbn(rs.getInt("isbn"));
                    book.setPublishYear(rs.getInt("publishYear"));
                    return book;
                }

                return null;
            }

        });
    }
}
