
insert into genres (title) values ('fiction'),
                                  ('drama'),
                                  ('detective'),
                                  ('poetry'),
                                  ('fantasy'),
                                  ('dystopia');

insert into authors (name, patronymic, surname) values ('Федор','Михалыч','Достоевский'),
                                                       ('Александр','Сергеевич','Пушкин'),
                                                       ('Джордж',null ,'Мартин'),
                                                       ('Джон Рональд',null ,'Толкиен'),
                                                       ('Олдос',null,'Хаксли'),
                                                       ('Герберт',null,'Уэлс'),
                                                       ('Джоан',null,'Роулинг'),
                                                       ('Френк',null ,'Гэрберт');

INSERT INTO books (title, author_id, genre_id) values ('Гарри поттер', 7, 5),
                                                     ('Война миров', 6, 1),
                                                     ('О дивный новый мир', 5, 6),
                                                     ('Дюна', 8, 1),
                                                     ('Онегин', 2, 4),
                                                     ('Двойник', 1, 2),
                                                     ('Танец драконов', 3, 5),
                                                     ('Хоббит', 4, 5);
