package jd2.task1.parent.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pers {
    @Value("1")
    private Long id;
    @Value("Bla")
    private String name;
    @Autowired
    private IAdress addr;
    public void init(){
        System.out.println("INIT PERSON METOD");
    }
}
