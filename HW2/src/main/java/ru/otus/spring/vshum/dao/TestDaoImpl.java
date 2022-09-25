package ru.otus.spring.vshum.dao;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.spring.vshum.constant.HeadersConstant;
import ru.otus.spring.vshum.entity.Answer;
import ru.otus.spring.vshum.entity.Question;
import ru.otus.spring.vshum.entity.Test;
import ru.otus.spring.vshum.parser.CSVParserOptions;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:application.properties")
@Component
public class TestDaoImpl implements TestDao {

    private final String testPath;
    private final CSVParserOptions parser;

    public TestDaoImpl(@Value("${csv.path}") String testPath, CSVParserOptions parser) {
        this.testPath = testPath;
        this.parser = parser;
    }

    public Test getTest() {

        List<Question> questions = getTestQuestions();

        return new Test(questions);
    }

    public List<Question> getTestQuestions(){

        parser.prepareFileFormat(testPath);

        List<CSVRecord> records = parser.getRecords();

        List<Question> questions = new ArrayList<>();
        for (CSVRecord record : records) {
            Question question = new Question();
            question.setId(record.getRecordNumber());
            question.setQuestion(record.get(HeadersConstant.QUESTION));
            question.setAnswers(new Answer(record.get(HeadersConstant.ANSWERS)));
            question.setCorrectAnswer(record.get(HeadersConstant.CORRECT_ANSWER));
            questions.add(question);
        }

        return questions;
    }

}
