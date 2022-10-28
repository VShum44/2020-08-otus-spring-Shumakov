package ru.otus.spring.vshum.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.configs.LocaleConfig;
import ru.otus.spring.vshum.entity.ARGSForMessageSource;
import ru.otus.spring.vshum.entity.LocaleMessage;
import ru.otus.spring.vshum.service.interfaces.LocaleMessageService;

@Service
public class LocaleMessageServiceImpl implements LocaleMessageService {
    private final LocaleConfig localeConfig;
    private final MessageSource messageSource;

    public LocaleMessageServiceImpl(LocaleConfig localeConfig,
                                    MessageSource messageSource) {
        this.localeConfig = localeConfig;
        this.messageSource = messageSource;
    }

    @Override
    public LocaleMessage createLocaleMessage(String code) {
        ARGSForMessageSource argsForMessageSource = new ARGSForMessageSource("");
        return new LocaleMessage(messageSource.getMessage(
                code, argsForMessageSource.getArgs() , localeConfig.getLocale()));
    }
}
