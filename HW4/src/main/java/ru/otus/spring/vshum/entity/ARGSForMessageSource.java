package ru.otus.spring.vshum.entity;

public class ARGSForMessageSource {
    
    private String [] args;

    public ARGSForMessageSource(String... args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String... args) {
        this.args = args;
    }
}
