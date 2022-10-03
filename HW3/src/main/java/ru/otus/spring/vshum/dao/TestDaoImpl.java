package ru.otus.spring.vshum.dao;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ru.otus.spring.vshum.constant.HeadersConstant;
import ru.otus.spring.vshum.entity.Answer;
import ru.otus.spring.vshum.entity.Question;
import ru.otus.spring.vshum.entity.Test;
import ru.otus.spring.vshum.parser.CSVParserOptions;

import java.util.ArrayList;
import java.util.List;


@Component
public class TestDaoImpl implements TestDao {

    private final CSVParserOptions parser;

    public TestDaoImpl(CSVParserOptions parser) {
        this.parser = parser;
    }

    @Override
    public Test getTest() {

        List<Question> questions = getTestQuestions();

        return new Test(questions);
    }

    @Override
    public List<Question> getTestQuestions(){

        List<CSVRecord> records = parser.getRecordsWithLocale();

        List<Question> questions = new ArrayList<>();
        for (CSVRecord record : records) {
            Question question = new Question(record.getRecordNumber());
            question.setQuestion(record.get(HeadersConstant.QUESTION));
            question.setAnswers(new Answer(record.get(HeadersConstant.ANSWERS)));
            question.setCorrectAnswer(record.get(HeadersConstant.CORRECT_ANSWER));
            questions.add(question);
        }

        return questions;
    }
}
