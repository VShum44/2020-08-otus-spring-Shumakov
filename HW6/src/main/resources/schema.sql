CREATE TABLE IF NOT EXISTS authors
(
    id integer auto_increment NOT NULL,
    name text NOT NULL,
    patronymic text,
    surname text NOT NULL,
    PRIMARY KEY (id)
    );


CREATE TABLE IF NOT EXISTS genres
(
    id integer auto_increment NOT NULL,
    title text NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS books
(
    id bigint auto_increment NOT NULL,
    title text NOT NULL,
    author_id integer NOT NULL,
    genre_id integer NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
    );

