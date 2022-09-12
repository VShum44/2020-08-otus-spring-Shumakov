package ru.otus.spring.vshum.entity;

public class Question {

    private long id;

    private String question;

    private Answer answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
