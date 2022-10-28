package ru.otus.spring.vshum.parser;

import org.apache.commons.csv.CSVRecord;

import java.util.List;


public interface CSVParserOptions {

    List<CSVRecord> getRecordsWithLocale();
    List<CSVRecord> getOriginalRecords();



}
