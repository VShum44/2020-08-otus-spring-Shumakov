package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.entity.Message;
import ru.otus.spring.vshum.service.interfaces.LocaleMessageService;
import ru.otus.spring.vshum.service.interfaces.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private final LocaleMessageService localeMessageService;

    public MessageServiceImpl( LocaleMessageService localeMessageService) {
        this.localeMessageService = localeMessageService;
    }
    @Override
    public Message createMessageWithLocale(String code){
        return localeMessageService.createLocaleMessage(code);
    }
}
