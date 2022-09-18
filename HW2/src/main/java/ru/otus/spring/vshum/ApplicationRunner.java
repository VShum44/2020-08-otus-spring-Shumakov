package ru.otus.spring.vshum;

import org.springframework.stereotype.Component;
import ru.otus.spring.vshum.controller.TestController;

@Component
public class ApplicationRunner {

    private final TestController testController;

    public ApplicationRunner(TestController testController) {
        this.testController = testController;
    }

    public void run(){
        testController.startTest();
    }
}
