package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.entity.Question;
import ru.otus.spring.vshum.dao.TestDao;
import ru.otus.spring.vshum.entity.Test;

import java.util.List;

public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    public TestServiceImpl(TestDao testDao){
        this.testDao = testDao;
    }

    @Override
    public Test getTest() {
        return testDao.getTest();
    }
}
