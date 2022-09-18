package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.entity.ResultMessage;

public interface ResultMessageService {

    ResultMessage getResultMessage(String respondentFullName,
                                   int respondentCorrectAnswerCount,
                                   int totalAnswerCount,
                                   boolean testPassed);
}
