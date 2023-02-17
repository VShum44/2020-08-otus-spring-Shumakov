package ru.otus.spring.vshum.wrapper.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.vshum.domain.Author;
import ru.otus.spring.vshum.domain.Genre;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookWrapper {

    private Long id;

    private String title;

    private Author author;

    private Genre genre;

}
