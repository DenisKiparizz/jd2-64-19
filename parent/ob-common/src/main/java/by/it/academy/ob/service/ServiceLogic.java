package by.it.academy.ob.service;

import by.it.academy.ob.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ServiceLogic implements ServiceInterface {
    public static final ServiceInterface INSTANCE = new ServiceLogic();
    public final List<Model> list;
    //AtomicLomg id;
    private Long id;
    private int nomber;


    public static ServiceInterface getService() {
        return INSTANCE;
    }

    public ServiceLogic() {
        id = 100L;
        list = new ArrayList<>();
    }

    @Override
    public List<Model> getListServices() {
        // return new list
        return list;
    }

    @Override
    public void addNewService(Model task) {
        task.setNomber(nomber++);
        // id++;
        //id.incrementAndGet;
        task.setId(id++);
        list.add(task);
    }

    @Override
    public void update(Model model) {
        for (Model a : list) {
            if (a.getId().equals(model.getId())) {
                a.setNomber(nomber++);
                a.setId(id++);
                a.setNameOfService(model.getNameOfService());
                a.setDescription(model.getDescription());
            }
        }
    }

    @Override
    public void deliteService1(Long id) {
        list.removeIf(a -> a.getId().equals(id));
    }

}
