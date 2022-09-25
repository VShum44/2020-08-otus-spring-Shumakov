package ru.otus.spring.vshum.entity;

public class ResultMessageTemplate {

    public final static String SUCCESS = ", your passed the test";

    public final static String FAIL = ", your didn't pass the test";

    private String respondentFullName;

    private int respondentCorrectAnswerCount;

    private int totalAnswerCount;

    private boolean testPassed;

    public ResultMessageTemplate(String respondentFullName, int respondentCorrectAnswerCount, int totalAnswerCount, boolean testPassed) {
        this.respondentFullName = respondentFullName;
        this.respondentCorrectAnswerCount = respondentCorrectAnswerCount;
        this.totalAnswerCount = totalAnswerCount;
        this.testPassed = testPassed;
    }

    public String getRespondentFullName() {
        return respondentFullName;
    }

    public void setRespondentFullName(String respondentFullName) {
        this.respondentFullName = respondentFullName;
    }

    public int getRespondentCorrectAnswerCount() {
        return respondentCorrectAnswerCount;
    }

    public void setRespondentCorrectAnswerCount(int respondentCorrectAnswerCount) {
        this.respondentCorrectAnswerCount = respondentCorrectAnswerCount;
    }

    public int getTotalAnswerCount() {
        return totalAnswerCount;
    }

    public void setTotalAnswerCount(int totalAnswerCount) {
        this.totalAnswerCount = totalAnswerCount;
    }

    public boolean isTestPassed() {
        return testPassed;
    }

    public void setTestPassed(boolean testPassed) {
        this.testPassed = testPassed;
    }
}
