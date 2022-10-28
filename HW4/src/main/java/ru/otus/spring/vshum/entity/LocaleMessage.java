package ru.otus.spring.vshum.entity;

import java.util.Locale;

public class LocaleMessage extends Message {

    private Locale locale;

    public LocaleMessage(String text) {
        super(text);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
