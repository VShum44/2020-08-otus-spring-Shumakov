package ru.otus.spring.vshum.entity;

public class ResultMessage {

    private StringBuilder text;

    public ResultMessage(String text) {
        this.text = new StringBuilder(text);
    }

    public String getText() {
        return text.toString();
    }

    public void setText(String text) {
        if(this.text.length() > 0){
            this.text.delete(0, this.text.length());
        }
        this.text.append(text);
    }

    public void addText(String text){
        this.text.append(text);
    }
}
