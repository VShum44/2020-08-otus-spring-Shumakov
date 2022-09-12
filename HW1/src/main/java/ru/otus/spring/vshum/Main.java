package ru.otus.spring.vshum;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.vshum.controller.TestController;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");

        TestController testController = context.getBean(TestController.class);
        testController.printAllTestQuestions();

    }
}
