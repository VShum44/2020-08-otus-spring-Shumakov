package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.entity.ResultMessage;
import ru.otus.spring.vshum.entity.ResultMessageTemplate;
import ru.otus.spring.vshum.service.interfaces.ResultMessageService;
import ru.otus.spring.vshum.service.interfaces.ResultMessageTemplateService;

@Service
public class ResultMessageServiceImpl implements ResultMessageService {


    private final ResultMessageTemplateService resultMessageTemplateService;

    public ResultMessageServiceImpl(ResultMessageTemplateService resultMessageTemplateService) {
        this.resultMessageTemplateService = resultMessageTemplateService;
    }

    @Override
    public ResultMessage getResultMessage(String respondentFullName, int respondentCorrectAnswerCount, int totalAnswersCount, boolean testPassed){

        return resultMessageTemplateService.makeResultMessageFromTemplate(
                new ResultMessageTemplate(
                        respondentFullName,
                        respondentCorrectAnswerCount,
                        totalAnswersCount,
                        testPassed)
        );
    }
}
