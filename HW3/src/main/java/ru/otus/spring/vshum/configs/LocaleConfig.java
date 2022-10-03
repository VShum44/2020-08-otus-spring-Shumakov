package ru.otus.spring.vshum.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@ConfigurationProperties(prefix = "application")
public class LocaleConfig {

    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
