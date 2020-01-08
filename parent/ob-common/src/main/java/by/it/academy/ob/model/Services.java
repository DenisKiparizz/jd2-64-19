package by.it.academy.ob.model;

import java.util.Objects;

public class Services {
    private Long id;
    private String typeOfService;
    private String nameOfService;
    private String description;
    private Long car_id;
    private Cars car;

    private Long carId;
    public Services(){}


    public Services(Long car_id, String typeOfService, String nameOfService, String description,Long id) {
        this.id = id;
        this.car_id = car.getId();
        this.typeOfService = typeOfService;
        this.nameOfService = nameOfService;
        this.description = description;
    }

    public Services(Long id, String typeOfService, String nameOfService, String description) {
        this.id = id;
        this.typeOfService = typeOfService;
        this.nameOfService = nameOfService;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Cars carId) {
        this.carId = carId.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services services = (Services) o;
        return getId().equals(services.getId()) &&
                getTypeOfService().equals(services.getTypeOfService()) &&
                getNameOfService().equals(services.getNameOfService()) &&
                getDescription().equals(services.getDescription()) &&
                getCar_id().equals(services.getCar_id()) &&
                getCar().equals(services.getCar()) &&
                getCarId().equals(services.getCarId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeOfService(), getNameOfService(), getDescription(), getCar_id(), getCar(), getCarId());
    }
}