package ru.otus.spring.vshum.wrapper;

import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.domain.Genre;

public class BookWrapper {

    private long id;

    private String title;

    private Author author;

    private Genre genre;

    public BookWrapper() {
    }

    public BookWrapper(long id, String title, Author author, Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book: " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", author = " + author.getName() + " " + author.getSurname() +
                ", genre = " + genre.getTitle();
    }
}
