package main.java.model;

public class Book {
    private int id;
    private String title;
    private int isbn;
    private int publishYear;

    public Book() {

    }

    public Book(String title, int isbn, int publishYear) {
        this.title = title;
        this.isbn = isbn;
        this.publishYear = publishYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

}
