package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.entity.ResultMessage;
import ru.otus.spring.vshum.entity.ResultMessageTemplate;

@Service
public class ResultMessageServiceImpl implements ResultMessageService{


    private final ResultMessageTemplateServiceImpl resultMessageTemplateService;

    public ResultMessageServiceImpl(ResultMessageTemplateServiceImpl resultMessageTemplateService) {
        this.resultMessageTemplateService = resultMessageTemplateService;
    }

    public ResultMessage getResultMessage(String respondentFullName, int respondentCorrectAnswerCount, int totalAnswersCount, boolean testPassed){

        return resultMessageTemplateService.makeMessageFromTemplate(
                new ResultMessageTemplate(
                        respondentFullName,
                        respondentCorrectAnswerCount,
                        totalAnswersCount,
                        testPassed)
        );
    }
}
