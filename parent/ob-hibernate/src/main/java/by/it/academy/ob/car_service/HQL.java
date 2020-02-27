package by.it.academy.ob.car_service;

import by.it.academy.ob.car_service.entity.*;
import by.it.academy.ob.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HQL {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User denis = new User("Denis", "Solodkiy", 25);
        User donald = new User("Donald", "Tramp", 73);

        Service engine = new Service("Engine");
        Service body = new Service("Body");
        Service wheels = new Service("Set wheels form ");
        Service mechanical = new Service("Mechanical");
        Service swap = new Service("Swap SPOON engine");
        Service brakes = new Service("Brakes");

        Car honda = new Car("Honda");
        Car porshe = new Car("Porche");

        ModelCar hondaAccord = new ModelCar("Accord", honda);
        ModelCar hondaCivic = new ModelCar("Civic", honda);
        ModelCar hondaCRX = new ModelCar("CRX", honda);
        ModelCar hondaPrelude = new ModelCar("Prelude", honda);
        ModelCar porshe911 = new ModelCar("911", porshe);
        ModelCar porsheCaymanS = new ModelCar("CaymanS", porshe);
        ModelCar porsheSpider = new ModelCar("Spider", porshe);

        OrderForm denisForm = new OrderForm(null, "Dont have brakes", hondaCRX, denis);
        OrderForm donaldForm = new OrderForm(null, "I'd like to be like a bullet", porsheCaymanS, donald);

        session.save(denis);
        session.save(donald);

        session.save(engine);
        session.save(body);
        session.save(wheels);
        session.save(mechanical);
        session.save(swap);
        session.save(brakes);

        session.save(honda);
        session.save(porshe);

        session.save(hondaAccord);
        session.save(hondaCivic);
        session.save(hondaCRX);
        session.save(hondaPrelude);
        session.save(porshe911);
        session.save(porsheCaymanS);
        session.save(porsheSpider);

        denisForm.getServices().add(brakes);
        donaldForm.getServices().add(swap);
        session.saveOrUpdate(denisForm);
        session.saveOrUpdate(donaldForm);

        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<User> selectFromUser = session.createQuery("from User", User.class);
        List<User> userList = selectFromUser.list();

        Query<ModelCar> selectFromModelCar = session.createQuery("from ModelCar", ModelCar.class);
        List<ModelCar> modelCarList = selectFromModelCar.list();

        Query selectFromMake = session.createQuery("SELECT e.make from Car as e");
        List makeList = selectFromMake.list();

        Query<OrderForm> selectFromOrderForm = session.createQuery("from OrderForm", OrderForm.class);
        List<OrderForm> orderFormList = selectFromOrderForm.list();

        Query countServices = session.createQuery("SELECT count(m.model) from ModelCar m where make.make =:make");
        countServices.setParameter("make", "Honda");
        List serviceCount = countServices.list();

        session.getTransaction().commit();
        session.close();

        System.err.println(userList.toString());
        System.err.println(modelCarList.toString());
        System.err.println(makeList.toString());
        System.err.println(orderFormList.toString());
        System.err.println(serviceCount.toString());

        HibernateUtil.shutdown();
    }
}
