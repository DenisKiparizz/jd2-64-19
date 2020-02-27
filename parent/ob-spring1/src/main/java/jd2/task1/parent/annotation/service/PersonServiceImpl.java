package jd2.task1.parent.annotation.service;

import jd2.task1.parent.annotation.Pers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private Pers person;

    @Override
    public String getNAme() {
        return person.getName();
    }
    @PostConstruct
    public void init(){
    }
    @PreDestroy
    public void destroy(){

    }
}
