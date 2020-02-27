package by.it.academy.ob.model.cars;

import java.util.Date;
import java.util.Objects;

public class Car {
    private Long carID;
    private Make make;
    private Long make_id;
    private Model model;
    private Long model_id;
    private Body body;
    private Long body_id;
    private Engine engine;
    private Long engine_id;

    public Car(Long carID, Make make, Model model, Body body, Engine engine, Long engineValue, Date releaseDate) {
        this.carID = carID;
        this.make_id = make.getId();
        this.model_id = model.getId();
        this.body_id = body.getId();
        this.engine_id = engine.getEngineID();
        this.engineValue = engineValue;
        this.releaseDate = releaseDate;
    }

    public Car(Long carID, Make make, Model model, Body body) {
        this.carID = carID;
        this.make_id = make.getId();
        this.model_id = model.getId();
        this.body_id = body.getId();
    }

    public Long getEngineValue() {
        return engineValue;
    }

    public void setEngineValue(Long engineValue) {
        this.engineValue = engineValue;
    }

    private Long engineValue;
    private Date releaseDate;
    private Long vin;

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Long getMake_id() {
        return make_id;
    }

    public void setMake_id(Long make_id) {
        this.make_id = make.getId();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Long getModel_id() {
        return model_id;
    }

    public void setModel_id(Long model_id) {
        this.model_id = model.getId();
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Long getBody_id() {
        return body_id;
    }

    public void setBody_id(Long body_id) {
        this.body_id = body.getId();
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Long getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(Long engine_id) {
        this.engine_id = engine.getEngineID();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getVin() {
        return vin;
    }

    public void setVin(Long vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getCarID().equals(car.getCarID()) &&
                getMake().equals(car.getMake()) &&
                getMake_id().equals(car.getMake_id()) &&
                getModel().equals(car.getModel()) &&
                getModel_id().equals(car.getModel_id()) &&
                getBody().equals(car.getBody()) &&
                getBody_id().equals(car.getBody_id()) &&
                getEngine().equals(car.getEngine()) &&
                getEngine_id().equals(car.getEngine_id()) &&
                getEngineValue().equals(car.getEngineValue()) &&
                getReleaseDate().equals(car.getReleaseDate()) &&
                getVin().equals(car.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarID(), getMake(), getMake_id(), getModel(), getModel_id(), getBody(), getBody_id(), getEngine(), getEngine_id(), getEngineValue(), getReleaseDate(), getVin());
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", make=" + make +
                ", make_id=" + make_id +
                ", model=" + model +
                ", model_id=" + model_id +
                ", body=" + body +
                ", body_id=" + body_id +
                ", engine=" + engine +
                ", engine_id=" + engine_id +
                ", releaseDate=" + releaseDate +
                ", vin=" + vin +
                '}';
    }
}
