package ru.otus.spring.vshum.wrapper;

public class BookCommentWrapper {

    private String text;

    private long bookId;

    public BookCommentWrapper() {
    }

    public BookCommentWrapper(String text, long bookId) {
        this.text = text;
        this.bookId = bookId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
