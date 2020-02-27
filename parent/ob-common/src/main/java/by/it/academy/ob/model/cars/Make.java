package by.it.academy.ob.model.cars;

import java.util.Objects;

public class Make {
    private Long id;
    private String name;

    public Make(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Make() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Make make = (Make) o;
        return getId().equals(make.getId()) &&
                getName().equals(make.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
