package ru.otus.spring.vshum.parser;

import org.apache.commons.csv.CSVRecord;

import java.util.List;

public interface CSVParserOptions {

    void prepareFileFormat(String testPath);

    List<CSVRecord> getRecords();
}
