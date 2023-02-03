package ru.otus.spring.vshum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) throws SQLException {

//        Console.main(args);
        ApplicationContext context = SpringApplication.run(ApplicationStarter.class);

    }
}
