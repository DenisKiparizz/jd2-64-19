package OneToOne;

import OneToOne.employ.Departament;
import OneToOne.employ.EmployDetails;
import OneToOne.employ.Employee;
import OneToOne.employ.Meeting;
import by.it.academy.ob.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Departament departament = new Departament("Develop");
        EmployDetails detail = new EmployDetails(null, "Street", "city", "state", "country", null);
        Employee employee = new Employee(null, "Denis", "Kipariz", LocalDateTime.now(), null, departament, new ArrayList<>());
        Employee employee3 = new Employee(null, "Kimany", "Saronto", LocalDateTime.now(), null, departament, new ArrayList<>());
        Meeting meeting = new Meeting("Bla bla bla");
        Employee employee1 = new Employee(null, "Kristian", "BlaMany", null, null, null, new ArrayList<>());

        //OneToOne
        employee.setEmployDetails(detail);
        detail.setEmployee(employee);

        //OneToMany
        session.save(employee3);
        session.save(employee1);
        session.save(departament);

        //ManyToMany
        employee1.getMeeting().add(meeting);
        session.saveOrUpdate(employee1);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
