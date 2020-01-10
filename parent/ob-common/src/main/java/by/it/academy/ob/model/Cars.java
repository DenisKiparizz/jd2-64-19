package by.it.academy.ob.model;

import java.util.Objects;

public class Cars {
    private Long id;
    private String make;
    private String model;
    private String body;
    private String typeOfEngine;
    private Long age;
    private Double valueOfEngine;
    public volatile int nomber;
    public Cars(){}

    public Cars(String make) {
        this.make = make;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Cars(String make, String model,String body, String typeOfEngine, Double valueOfEngine, Long age, Long ide) {
        this.id = id;
        this.body = body;
        this.make = make;
        this.model = model;
        this.typeOfEngine = typeOfEngine;
        this.age = age;
        this.valueOfEngine = valueOfEngine;
    }

    public int getNomber() {
        return nomber;
    }

    public void setNomber(int nomber) {
        this.nomber = nomber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypeOfEngine() {
        return typeOfEngine;
    }

    public void setTypeOfEngine(String typeOfEngine) {
        this.typeOfEngine = typeOfEngine;
    }

    public Double getValueOfEngine() {
        return valueOfEngine;
    }

    public void setValueOfEngine(Double valueOfEngine) {
        this.valueOfEngine = valueOfEngine;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return getId().equals(cars.getId()) &&
                getMake().equals(cars.getMake()) &&
                getModel().equals(cars.getModel()) &&
                getTypeOfEngine().equals(cars.getTypeOfEngine()) &&
                getValueOfEngine().equals(cars.getValueOfEngine()) &&
                getAge().equals(cars.getAge());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(), getTypeOfEngine(), getValueOfEngine(), getAge());
    }
}
