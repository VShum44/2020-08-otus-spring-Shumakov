package ru.otus.spring.vshum.dao;

import ru.otus.spring.vshum.constant.HeadersConstant;
import ru.otus.spring.vshum.entity.Answer;
import ru.otus.spring.vshum.entity.Question;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.vshum.entity.Test;
import ru.otus.spring.vshum.parser.CSVParserOptions;

import java.util.ArrayList;
import java.util.List;

public class TestDaoImpl implements TestDao {

    private final String testPath;
    private CSVParserOptions parser;

    public TestDaoImpl(String testPath, CSVParserOptions parser) {
        this.testPath = testPath;
        this.parser = parser;
    }

    public Test getTest() {

        parser.prepareFileFormat(testPath);

        List<CSVRecord> records = parser.getRecords();
        List<Question> questions = new ArrayList<>();

        for (CSVRecord record : records) {
            Question question = new Question();
            question.setId(record.getRecordNumber());
            question.setQuestion(record.get(HeadersConstant.QUESTION));
            question.setAnswers(new Answer(record.get(HeadersConstant.ANSWERS)));
            questions.add(question);
        }

        return new Test(questions);
    }

}
