package ru.otus.spring.vshum.domain;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private  Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Fetch(FetchMode.JOIN)
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "book",orphanRemoval = true)
    private List<BookComment> bookComments;

    public Book() {
    }

    public Book(String title,  Author author, Genre genre) {
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

    public List<BookComment> getComments() {
        return bookComments;
    }

    public void setComments(List<BookComment> bookComments) {
        this.bookComments = bookComments;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id +
                ", title:'" + title + '\'' +
                ", author = id: " + author.getId() + ", name: " + author.getName() + " " + author.getSurname() +
                ", genre = id: " + genre.getId() + " - " + genre.getTitle() + "}\n";
    }
}
