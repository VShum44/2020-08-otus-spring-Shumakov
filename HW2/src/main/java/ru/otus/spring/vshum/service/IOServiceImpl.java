package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService{

    private final PrintStream printer;
    private final Scanner reader;

    public IOServiceImpl() {
        this.printer = new PrintStream(System.out);
        this.reader = new Scanner(System.in);
    }

    @Override
    public void printString(String s) {
          printer.println(s);
    }

    @Override
    public String readString() {
        return reader.next();
    }

    @Override
    public String readStringWithPrompt(String prompt) {
        printer.println(prompt);
        return reader.next();
    }
}
