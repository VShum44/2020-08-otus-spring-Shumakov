package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.dao.TestDao;
import ru.otus.spring.vshum.entity.Test;
import ru.otus.spring.vshum.service.interfaces.TestService;

@Service
public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test getTest() {
        return testDao.getTest();
    }

}
