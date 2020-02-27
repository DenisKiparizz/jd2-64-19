

package jd2.task1.parent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring=config.xml");
        ErrorPrinter errorPrinter = context.getBean("errorPrinter", ErrorPrinter.class);
        ConsolePrinter consolePrinter = context.getBean("consolePrinter", ConsolePrinter.class);
        PrintService printService = context.getBean("printService", PrintService.class);

        printService.setPrinter(errorPrinter);
        printService.printMassage("Hello from PrintService with error");







    }
}


