package by.it.academy.ob.service;

import by.it.academy.ob.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ServiceLogic implements ServiceInterface {
    public static final ServiceInterface INSTANCE = new ServiceLogic();
    public final List<Model> list;
    private final AtomicLong id = new AtomicLong(100);
    private int nomber;

    public static ServiceInterface getService() {
        return INSTANCE;
    }

    public ServiceLogic() {
        list = new ArrayList<>();
    }

    @Override
    public List<Model> getListServices() {
      return list;
    }

    @Override
    public void addNewService(Model task) {
        task.setNomber(nomber++);
        task.setId(id.incrementAndGet());
        list.add(task);
    }

    @Override
    public void update(Model model) {
        for (Model a : list) {
            if (a.getId().equals(model.getId())) {
                a.setNomber(nomber++);
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
