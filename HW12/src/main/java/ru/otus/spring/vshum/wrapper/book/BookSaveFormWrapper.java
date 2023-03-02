package ru.otus.spring.vshum.wrapper.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.domain.Genre;

import java.util.List;

@Data
@NoArgsConstructor
public class BookSaveFormWrapper {

    private List<Genre> genres;

    private List<Author> authors;

    public BookSaveFormWrapper(List<Genre> genres, List<Author> authors) {
        this.genres = genres;
        this.authors = authors;
    }
}
