package by.it.academy.ob.model.cars;

import java.util.Objects;

public class Body {
    private Long id;
    private String typeOfBody;

    public Body(Long id, String typeOfBody) {
        this.id = id;
        this.typeOfBody = typeOfBody;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(String typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return getId().equals(body.getId()) &&
                getTypeOfBody().equals(body.getTypeOfBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeOfBody());
    }
}
