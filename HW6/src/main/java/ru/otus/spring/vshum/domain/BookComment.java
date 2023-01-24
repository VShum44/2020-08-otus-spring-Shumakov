package ru.otus.spring.vshum.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments_to_book")
public class BookComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "book_id")
    private long bookId;

    public BookComment() {
    }

    public BookComment(String text, long bookId) {
        this.text = text;
        this.bookId = bookId;
    }

    public BookComment(long id, String text, long bookId) {
        this.id = id;
        this.text = text;
        this.bookId = bookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
