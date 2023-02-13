package ru.otus.spring.vshum.wrapper;

import ru.otus.spring.vshum.domain.BookComment;

import java.util.List;

public class BookWrapperToShow {

    private String title;

    private String author;

    private String genre;

    private List<BookComment> comments;

    public BookWrapperToShow(String title, String author,
                             String genre,
                             List<BookComment> bookComments) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.comments = bookComments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<BookComment> getComments() {
        return comments;
    }

    public void setComments(List<BookComment> bookComments) {
        this.comments = bookComments;
    }

    @Override
    public String toString(){
        
        StringBuilder bookToShow = new StringBuilder(
                String.format("====== Книга под названием: \"%s\", автор: %s, жанр: %s =======",
                title, author, genre)
        );

        if(comments != null && !comments.isEmpty()) {
            bookToShow.append("\n Комментарии:");

            for (int i = 0; i < comments.size() ; i++) {
                bookToShow.append("\n+---------------------------\n");
                bookToShow.append("| Комментарий#" + i + " : " + comments.get(i).getText());

                if(i == comments.size() - 1){
                    bookToShow.append("\n+---------------------------\n");
                }
            }
        }
        else{
            bookToShow.append("\nКомментарии отсутствуют\n");
        }
        return bookToShow.toString();
    }
}
