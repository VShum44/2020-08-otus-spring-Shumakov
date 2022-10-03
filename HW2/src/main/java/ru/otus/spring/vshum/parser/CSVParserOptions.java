package ru.otus.spring.vshum.parser;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CSVParserOptions {

    List<CSVRecord> getRecords(String testPath);
}
