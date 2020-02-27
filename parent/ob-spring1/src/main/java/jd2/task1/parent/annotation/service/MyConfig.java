package jd2.task1.parent.annotation.service;

import jd2.task1.parent.annotation.Pers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "jd2.task1.parent.annotation")
public class MyConfig {
    @Bean()
    public Pers getPers() {
        Pers person = new Pers();
        person.setName("FROM CONFIG");
        return person;
    }
}
