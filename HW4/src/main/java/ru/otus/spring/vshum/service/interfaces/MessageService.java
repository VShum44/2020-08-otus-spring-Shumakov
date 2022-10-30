package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.entity.Message;

public interface MessageService {

    Message createMessageWithLocale(String code);
}
