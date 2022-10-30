package ru.otus.spring.vshum.entity;

public class QuestionResult {

    private long questionId;

    private String respondentAnswer;

    private String correctAnswer;

    public QuestionResult(long questionId, String respondentAnswer, String correctAnswer) {
        this.questionId = questionId;
        this.respondentAnswer = respondentAnswer;
        this.correctAnswer = correctAnswer;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getRespondentAnswer() {
        return respondentAnswer;
    }

    public void setRespondentAnswer(String respondentAnswer) {
        this.respondentAnswer = respondentAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
