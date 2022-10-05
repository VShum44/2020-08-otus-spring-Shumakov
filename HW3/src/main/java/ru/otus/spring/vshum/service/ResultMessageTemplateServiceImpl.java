package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.constant.LocaleMessageConst;
import ru.otus.spring.vshum.entity.ResultMessage;
import ru.otus.spring.vshum.entity.ResultMessageTemplate;
import ru.otus.spring.vshum.service.interfaces.MessageService;
import ru.otus.spring.vshum.service.interfaces.ResultMessageTemplateService;

@Service
public class ResultMessageTemplateServiceImpl implements ResultMessageTemplateService {

    private final MessageService messageService;

    public ResultMessageTemplateServiceImpl(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public ResultMessage makeResultMessageFromTemplate(ResultMessageTemplate template) {

        String result = template.isTestPassed()
                ? messageService.createMessageWithLocale(LocaleMessageConst.PASSED).getText()
                : messageService.createMessageWithLocale(LocaleMessageConst.FAIL).getText();

        return new ResultMessage(
                template.getRespondentFullName() + ", "
                        + result + "\n"
                        + messageService.createMessageWithLocale(LocaleMessageConst.YOUR_SCORE).getText() + " "
                        + template.getRespondentCorrectAnswerCount() + " "
                        + messageService.createMessageWithLocale(LocaleMessageConst.FROM).getText() + " "
                        + template.getTotalAnswerCount()
        );
    }
}
