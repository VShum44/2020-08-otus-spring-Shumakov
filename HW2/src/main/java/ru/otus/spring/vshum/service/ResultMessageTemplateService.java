package ru.otus.spring.vshum.service;

import ru.otus.spring.vshum.entity.ResultMessage;
import ru.otus.spring.vshum.entity.ResultMessageTemplate;

public interface ResultMessageTemplateService {

    ResultMessage makeMessageFromTemplate(ResultMessageTemplate template);
}
