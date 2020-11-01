package main.java.dao;

import java.util.List;

import main.java.model.Book;

public interface BookDAO {

    public void saveOrUpdate(Book book);

    public void delete(int id);

    public Book get(int id);

    public List<Book> list();

}
