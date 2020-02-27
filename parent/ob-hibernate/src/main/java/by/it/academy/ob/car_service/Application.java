package by.it.academy.ob.car_service;

import by.it.academy.ob.car_service.entity.*;
import by.it.academy.ob.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user1 = new User("Denis", "Solodkiy", 25);

        Service engine = new Service("Engine Check");
        Service body = new Service("Welding Job");

        Car honda = new Car("Honda");
        Car bmw = new Car("BMW");
        ModelCar h1 = new ModelCar("Accord", honda);
        ModelCar b1 = new ModelCar("e46", bmw);

        OrderForm ob1 = new OrderForm(null, "Accord", h1, user1, new ArrayList<>());
        OrderForm ob2 = new OrderForm(null, "e46", b1, user1, new ArrayList<>());

//OneToMany
        session.save(user1);
        session.save(honda);
        session.save(bmw);
        session.save(engine);
        session.save(body);
        session.save(h1);
        session.save(b1);
//ManyToMany
        ob1.getServices().add(body);
        ob2.getServices().add(engine);
        session.saveOrUpdate(ob1);
        session.saveOrUpdate(ob2);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
