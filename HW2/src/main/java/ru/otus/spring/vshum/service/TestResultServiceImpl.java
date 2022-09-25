package ru.otus.spring.vshum.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.entity.QuestionResult;
import ru.otus.spring.vshum.entity.TestResult;

@Service
public class TestResultServiceImpl implements TestResultService {

    private final int correctAnswersToPassCount;

    private final ResultMessageServiceImpl resultMessageServiceImpl;
    private final RespondentService respondentService;

    public TestResultServiceImpl(@Value("${correctAnswersToPassCount}") int correctAnswersToPassCount, ResultMessageServiceImpl resultMessageServiceImpl, RespondentService respondentService) {
        this.correctAnswersToPassCount = correctAnswersToPassCount;
        this.resultMessageServiceImpl = resultMessageServiceImpl;
        this.respondentService = respondentService;
    }

    public String showResult(TestResult testResult) {

        resultsProcessing(testResult);

        testResult.setIsTestPassed(isResultSuccess(testResult.getRespondentCorrectAnswerCount()));

        return resultMessageServiceImpl.getResultMessage(
                respondentService.getRespondentFullName(testResult.getRespondent()),
                testResult.getRespondentCorrectAnswerCount(),
                testResult.getQuestionResultList().size(),
                testResult.isTestPassed()
        ).getText();

    }

    private boolean isResultSuccess(int correctAnswersCount) {
        return correctAnswersCount >= correctAnswersToPassCount;
    }

    private void resultsProcessing(TestResult testResult) {
        int correctAnswerCount = 0;
        for (QuestionResult result : testResult.getQuestionResultList()) {
            if (result.getRespondentAnswer().equals(result.getCorrectAnswer())) {
                correctAnswerCount++;
            }
        }
        testResult.setRespondentCorrectAnswerCount(correctAnswerCount);
    }

}
