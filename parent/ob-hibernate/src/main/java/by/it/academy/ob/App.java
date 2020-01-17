package by.it.academy.ob;

import by.it.academy.ob.dao.Impl.PersonDaoImpl;
import by.it.academy.ob.dao.PersonDao;
import by.it.academy.ob.entity.Address;
import by.it.academy.ob.entity.Person;
import by.it.academy.ob.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.dialect.H2Dialect;

public class App {
    public static final PersonDao service = PersonDaoImpl.getInstance();
    public static void main(String[] args) {
        Person ob1 = new Person(null, "Kventin", "Tarantino", 42,null, new Address("USA", "BrigtonBeeach", 10010) );
        Person ob2 = new Person(null, "Cirtis", "Jackson", 47,null, new Address("New York", "New York", 490888) );
        Person ob3 = new Person(null, "Mara", "Salvatruchi", 89,null, new Address("New Mexico","Calvanos", 10010) );
        service.create(ob1);
        service.create(ob2);
        service.create(ob3);
        System.out.println(service.read(3L));
        HibernateUtil.shutdown();

    }
}
