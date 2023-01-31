package ru.otus.spring.vshum.wrapper;

public class BookWrapper {

    private String title;

    private int authorId;

    private int genreId;

    public BookWrapper() {
    }

    public BookWrapper(String title, int authorId, int genreId) {
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
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
