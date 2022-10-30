package ru.otus.spring.vshum.entity;

import java.util.List;

public class TestResult {

    private Respondent respondent;

    private int respondentCorrectAnswerCount;

    private List<QuestionResult> questionResultList;

    private boolean testPassed;

    public List<QuestionResult> getQuestionResultList() {
        return questionResultList;
    }

    public void setQuestionResultList(List<QuestionResult> questionResultList) {
        this.questionResultList = questionResultList;
    }

    public Respondent getRespondent() {
        return respondent;
    }

    public boolean isTestPassed() {
        return testPassed;
    }

    public void setIsTestPassed(boolean testPassed) {
        this.testPassed = testPassed;
    }

    public void setRespondent(Respondent respondent) {
        this.respondent = respondent;
    }

    public int getRespondentCorrectAnswerCount() {
        return respondentCorrectAnswerCount;
    }

    public void setRespondentCorrectAnswerCount(int respondentCorrectAnswerCount) {
        this.respondentCorrectAnswerCount = respondentCorrectAnswerCount;
    }
}
