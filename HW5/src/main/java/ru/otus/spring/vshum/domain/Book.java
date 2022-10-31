package ru.otus.spring.vshum.domain;

public class Book {

    private long id;

    private String title;

    private int authorId;

    private int genreId;

    public Book(long id, String title, int authorId, int genreId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public Book(String title, int authorId, int genreId) {
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

}
