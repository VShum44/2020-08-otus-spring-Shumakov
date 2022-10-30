package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.entity.TestResult;

public interface TestResultService {

    String showResult(TestResult testResult);

    String setRespondentData(String text);
}
