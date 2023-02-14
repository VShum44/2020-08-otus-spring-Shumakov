package ru.otus.spring.vshum.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWrapperFromForm {

    /*
    id: 1
    title: Гарри поттер sdad
    author: Джоан
    genre: fantasy
     */

    private long id;

    private String title;

    private String author;

    private String genre;
}
