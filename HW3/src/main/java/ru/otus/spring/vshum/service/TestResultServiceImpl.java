package ru.otus.spring.vshum.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.entity.Message;
import ru.otus.spring.vshum.entity.QuestionResult;
import ru.otus.spring.vshum.entity.TestResult;
import ru.otus.spring.vshum.service.interfaces.IOService;
import ru.otus.spring.vshum.service.interfaces.RespondentService;
import ru.otus.spring.vshum.service.interfaces.ResultMessageService;
import ru.otus.spring.vshum.service.interfaces.TestResultService;

@Service
public class TestResultServiceImpl implements TestResultService {

    private final int correctAnswersToPassCount;

    private final ResultMessageService resultMessageService;
    private final RespondentService respondentService;
    private final MessageServiceImpl messageService;
    private final IOService ioService;

    public TestResultServiceImpl(@Value("${correctAnswersToPassCount}") int correctAnswersToPassCount,
                                 ResultMessageService resultMessageService,
                                 RespondentService respondentService,
                                 MessageServiceImpl messageService,
                                 IOService ioService) {
        this.correctAnswersToPassCount = correctAnswersToPassCount;
        this.resultMessageService = resultMessageService;
        this.respondentService = respondentService;
        this.messageService = messageService;
        this.ioService = ioService;
    }

    @Override
    public String showResult(TestResult testResult) {

        resultsProcessing(testResult);

        testResult.setIsTestPassed(isResultSuccess(testResult.getRespondentCorrectAnswerCount()));

        return resultMessageService.getResultMessage(
                respondentService.getRespondentFullName(testResult.getRespondent()),
                testResult.getRespondentCorrectAnswerCount(),
                testResult.getQuestionResultList().size(),
                testResult.isTestPassed()
        ).getText();

    }

    @Override
    public String setRespondentData(String text) {
        Message message = messageService.createMessageWithLocale(text);
        return ioService.readStringWithPrompt(message.getText());
    }

    private boolean isResultSuccess(int correctAnswersCount) {
        return correctAnswersCount >= correctAnswersToPassCount;
    }

    private void resultsProcessing(TestResult testResult) {
        int correctAnswerCount = 0;
        for (QuestionResult result : testResult.getQuestionResultList()) {
            String respondentAnswer = result.getRespondentAnswer().trim().toLowerCase();
            if (respondentAnswer.equals(result.getCorrectAnswer().trim())) {
                correctAnswerCount++;
            }
        }
        testResult.setRespondentCorrectAnswerCount(correctAnswerCount);
    }

}
