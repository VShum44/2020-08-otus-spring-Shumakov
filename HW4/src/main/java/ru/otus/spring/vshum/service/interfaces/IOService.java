package ru.otus.spring.vshum.service.interfaces;

public interface IOService {

    void printString(String s);

    String readString();

    String readStringWithPrompt(String prompt);
}
