package persistence.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.ControllerConfig;

public final class RelationMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ControllerConfig.class);
        System.out.println("----------ooo----------");
        context.getBean(UnRelatedController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(PersonaController.class).process();
        System.out.println("----------ooo----------");
        ((AbstractApplicationContext) context).close();
    }
}
