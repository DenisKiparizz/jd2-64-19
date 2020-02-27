package jd2.task1.parent.annotation;

import jd2.task1.parent.App;
import jd2.task1.parent.annotation.service.MyConfig;
import jd2.task1.parent.annotation.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App1 {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext("spring=config.xml");
//        Pers bean = ap.getBean(Pers.class);
        AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(MyConfig.class);

//        ap.refresh();
//        ap.start();


        PersonService been = ap.getBean(PersonService.class);
        System.out.println("Person" + been.getNAme());
        ap.close();
    }
}
