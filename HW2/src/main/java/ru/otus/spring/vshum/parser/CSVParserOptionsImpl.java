package ru.otus.spring.vshum.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ru.otus.spring.vshum.constant.HeadersConstant;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class CSVParserOptionsImpl implements CSVParserOptions {

    private Reader reader;
    private CSVFormat csvFormatForTest;

    public List<CSVRecord> getRecords(String testPath) {

        InputStream inputStream = getResourceStream(testPath);
        reader = new InputStreamReader(getResourceStream(testPath));
        csvFormatForTest = getCSVFormat();

        List<CSVRecord> records = null;
        try {
            CSVParser parser = new CSVParser(reader, csvFormatForTest);
            records = parser.getRecords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    private InputStream getResourceStream(String path) {
        return CSVParserOptionsImpl.class.getResourceAsStream(path);
    }

    private CSVFormat getCSVFormat() {
        return CSVFormat.Builder
                .create(CSVFormat.DEFAULT)
                .setHeader(HeadersConstant.QUESTION, HeadersConstant.ANSWERS, HeadersConstant.CORRECT_ANSWER)
                .setSkipHeaderRecord(true)
                .build();
    }
}
