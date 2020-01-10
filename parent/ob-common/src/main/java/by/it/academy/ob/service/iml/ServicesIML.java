package by.it.academy.ob.service.iml;

import by.it.academy.ob.model.Cars;
import by.it.academy.ob.model.Services;
import by.it.academy.ob.service.ServicesInterface;


import java.util.ArrayList;
import java.util.List;

public class ServicesIML implements ServicesInterface {
    public static final ServicesInterface INSTANCE = new ServicesIML();
    public final List<Services> servicesList;
    public static Cars car;

    public static ServicesInterface getInstance() {
        return INSTANCE;
    }
    public ServicesIML() {
        servicesList = new ArrayList<>();
    }
    @Override
    public List<Services> ListServices() {
        return servicesList;
    }

    @Override
    public void addServices(Services services) {
        servicesList.add(services);
    }
}
