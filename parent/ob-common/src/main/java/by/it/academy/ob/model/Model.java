package by.it.academy.ob.model;

import java.util.Objects;

public class Model {
    private String nameOfService;
    private String description;
    private Long id;
    public volatile int nomber;


    public int getNomber() {
        return nomber;
    }

    public void setNomber(int nomber) {
        this.nomber = nomber;

    }

    public Model(String nameOfService, String description, Long id ){
        this.nameOfService = nameOfService;
        this.id = id;
        this.description = description;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model service = (Model) o;
        return getNameOfService().equals(service.getNameOfService()) &&
                getDescription().equals(service.getDescription()) &&
                getId().equals(service.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfService(), getDescription(), getId(),getNomber());
    }

}
