package main.java.dao;

import java.util.List;

import main.java.model.Author;

public interface AuthorDAO {

    public void saveOrUpdate(Author author);

    public void delete(int id);

    public Author get(int id);

    public List<Author> list();
}
