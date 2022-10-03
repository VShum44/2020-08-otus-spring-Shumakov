package ru.otus.spring.vshum.service.interfaces;

import ru.otus.spring.vshum.entity.ResultMessage;
import ru.otus.spring.vshum.entity.ResultMessageTemplate;

public interface ResultMessageTemplateService {

    ResultMessage makeResultMessageFromTemplate(ResultMessageTemplate template);
}
