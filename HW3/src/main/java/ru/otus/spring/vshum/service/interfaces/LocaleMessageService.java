package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.entity.LocaleMessage;

public interface LocaleMessageService {
    LocaleMessage createLocaleMessage(String code);

}
