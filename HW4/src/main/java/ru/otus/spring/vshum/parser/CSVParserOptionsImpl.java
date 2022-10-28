package ru.otus.spring.vshum.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.vshum.constant.HeadersConstant;
import ru.otus.spring.vshum.service.interfaces.LocaleFileService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class CSVParserOptionsImpl implements CSVParserOptions {

    private final LocaleFileService localeFileService;

    private Reader reader;
    private CSVFormat csvFormatForTest;
    private final String filePath;

    public CSVParserOptionsImpl(LocaleFileService localeFileService,
                                @Value("${csv.path}") String filePath) {
        this.localeFileService = localeFileService;
        this.filePath = filePath;
    }

    @Override
    public List<CSVRecord> getRecordsWithLocale(){
        String filePathWithLocale = localeFileService.getFilePathWithLocale(filePath);

        return getRecords(filePathWithLocale);
    }

    @Override
    public List<CSVRecord> getOriginalRecords() {
        return getRecords(filePath);
    }

    private List<CSVRecord> getRecords(String filePath) {

        reader = new InputStreamReader(getResourceStream(filePath));
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
