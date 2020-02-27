package by.it.academy.ob.model.car_services;

public class ServiceT {
    private Long id;
    private String service_name;

    public ServiceT(Long id, String service_name) {
        this.id = id;
        this.service_name = service_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return service_name;
    }

    public void setName(String name) {
        this.service_name = service_name;
    }

}
