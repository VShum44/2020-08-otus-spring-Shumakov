package ru.otus.spring.vshum.controller;

import org.springframework.stereotype.Component;
import ru.otus.spring.vshum.entity.*;
import ru.otus.spring.vshum.service.IOService;
import ru.otus.spring.vshum.service.TestResultService;
import ru.otus.spring.vshum.service.TestService;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestController {

    private final IOService ioService;
    private final TestService testService;
    private final TestResultService testResultService;

    public TestController(IOService ioService, TestService testService, TestResultService testResultService) {
        this.ioService = ioService;
        this.testService = testService;
        this.testResultService = testResultService;
    }

    public void startTest() {

        Test test = testService.getTest();
        TestResult testResult = new TestResult();

        testResult.setRespondent(fillRespondentData());

        List<QuestionResult> questionResultList = printTestAndCollectResults(test);

        testResult.setQuestionResultList(questionResultList);

        ioService.printString(testResultService.showResult(testResult));
    }

    public Respondent fillRespondentData() {
        Respondent respondent = new Respondent();
        respondent.setName(ioService.readStringWithPrompt("Say your name"));
        respondent.setSecondName(ioService.readStringWithPrompt("Say your second name"));
        return respondent;
    }

    public List<QuestionResult> printTestAndCollectResults(Test test) {
        List<QuestionResult> questionResultList = new ArrayList<>();

        for (Question question : test.getQuestions()) {
            ioService.printString(question.getQuestion());
            String respondentAnswer = ioService.readStringWithPrompt(question.getAnswers().getContent());
            questionResultList.add(new QuestionResult(
                    question.getId(),
                    respondentAnswer,
                    question.getCorrectAnswer())
            );
        }
        return questionResultList;
    }
}
