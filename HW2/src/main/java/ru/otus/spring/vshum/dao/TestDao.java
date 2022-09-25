package ru.otus.spring.vshum.dao;

import ru.otus.spring.vshum.entity.Question;
import ru.otus.spring.vshum.entity.Test;

import java.util.List;

public interface TestDao {
    Test getTest();

    List<Question> getTestQuestions();
}
