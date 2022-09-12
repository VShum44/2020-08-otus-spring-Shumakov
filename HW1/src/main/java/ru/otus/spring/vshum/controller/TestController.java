package ru.otus.spring.vshum.controller;

import ru.otus.spring.vshum.entity.Question;
import ru.otus.spring.vshum.service.TestService;

import java.util.List;

public class TestController {

    private final TestService testService;

    public TestController (TestService testService){
        this.testService = testService;
    }

    public void printAllTestQuestions(){
        List<Question> questions = testService.getTest().getQuestions();
        for (Question question : questions) {
            System.out.println(question.getId() + ") " +question.getQuestion());
            System.out.println(question.getAnswers().getContent());
        }
    }
}
