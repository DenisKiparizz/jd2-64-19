package by.it.academy.ob.model.cars;

import java.util.Objects;

public class Engine {
    private Long engineID;
    private String typeOfEngine;

    public Engine(Long engineID, String typeOfEngine) {
        this.engineID = engineID;
        this.typeOfEngine = typeOfEngine;
    }

    public Long getEngineID() {
        return engineID;
    }

    public void setEngineID(Long engineID) {
        this.engineID = engineID;
    }

    public String getTypeOfEngine() {
        return typeOfEngine;
    }

    public void setTypeOfEngine(String typeOfEngine) {
        this.typeOfEngine = typeOfEngine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return getEngineID().equals(engine.getEngineID()) &&
                getTypeOfEngine().equals(engine.getTypeOfEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngineID(), getTypeOfEngine());
    }
}
