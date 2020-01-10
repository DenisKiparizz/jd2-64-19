package by.it.academy.ob.service.iml;

import by.it.academy.ob.service.CarsInterface;
import by.it.academy.ob.model.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CarsIml implements CarsInterface {
    public static final CarsInterface INSTANCE = new CarsIml();
    public final List<Cars> carsList;
    private final AtomicLong id = new AtomicLong(1);

    private final Map<String, Cars> cars = new ConcurrentHashMap<>();

    public static CarsInterface getInstance() {
        return INSTANCE;
    }

    public CarsIml() {
        carsList = new ArrayList<>();
    }

    @Override
    public List<Cars> listOfCars() {
        return carsList;
    }

    @Override
    public void addCar(Cars car) {
        car.setId(id.incrementAndGet());
        carsList.add(car);
    }

    @Override
    public Cars findById(Long id) {
        for (Map.Entry<String, Cars> val : cars.entrySet()) {
            if (val.getValue().getId().equals(id)) {
                return val.getValue();
            }
        }
        return null;
    }

    @Override
    public void deliteCar(Long id) {
        carsList.removeIf(a -> a.getId().equals(id));
    }

}
