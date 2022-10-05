package ru.otus.spring.vshum.entity;

public class Question {

    private final long id;

    private String question;

    private Answer answers;

    private String correctAnswer;

    public Question(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Answer getAnswers() {
        return answers;
    }

    public void setAnswers(Answer answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
