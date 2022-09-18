package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.entity.ResultMessage;
import ru.otus.spring.vshum.entity.ResultMessageTemplate;

@Service
public class ResultMessageTemplateServiceImpl implements ResultMessageTemplateService {

    public ResultMessage makeMessageFromTemplate(ResultMessageTemplate template) {

        String result = template.isTestPassed()
                ? ResultMessageTemplate.SUCCESS
                : ResultMessageTemplate.FAIL;

        return new ResultMessage(
                template.getRespondentFullName()
                        + result
                        + "\nYour score is "
                        + template.getRespondentCorrectAnswerCount()
                        + " from "
                        + template.getTotalAnswerCount()
        );
    }
}
