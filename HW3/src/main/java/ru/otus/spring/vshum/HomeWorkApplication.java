package ru.otus.spring.vshum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring.vshum.controller.TestController;

@SpringBootApplication
public class HomeWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeWorkApplication.class, args).getBean(TestController.class).startTest();
    }

}
