package ru.otus.spring.vshum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.vshum.controller.TestController;

@ComponentScan
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        context.getBean(ApplicationRunner.class).run();

    }
}
