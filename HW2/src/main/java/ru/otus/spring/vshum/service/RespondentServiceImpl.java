package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.entity.Respondent;

@Service
public class RespondentServiceImpl implements RespondentService {

    @Override
    public String getRespondentFullName(Respondent respondent) {
        return respondent.getName() + " " + respondent.getSecondName();
    }
}
