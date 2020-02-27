package jd2.task1.parent.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Addres implements IAdress {
    @Value("some street")
    private String street;
    @Value("company adress")
    private String companyAtreet;

}
