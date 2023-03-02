package ru.otus.spring.vshum;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) throws SQLException {

//        Console.main(args);
        ApplicationContext context = SpringApplication.run(ApplicationStarter.class);
        System.out.printf("Адрес приложения: %n%s%n%s%n",
                "http://localhost:8189/library/login", "http://localhost:8189/library/book/edit?id=1");

    }
}
