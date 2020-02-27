package by.it.academy.ob.model.car_services;

import java.util.Objects;

public class Order {
    private Long id;
    private String title;
    private ServiceT serviceT;
    private Long serviceType_id;
    private String description;

    public Order(Long id, String title, ServiceT serviceT, String description) {
        this.id = id;
        this.serviceT = serviceT;
        this.serviceType_id = serviceT.getId();
        this.description = description;
        this.title = title;
    }
    public Order() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceT getServiceT() {
        return serviceT;
    }

    public void setServiceT(ServiceT serviceT) {
        this.serviceT = serviceT;
    }

    public Long getServiceType_id() {
        return serviceType_id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setServiceType_id(Long serviceType_id) {
        this.serviceType_id = serviceT.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getId().equals(order.getId()) &&
                getTitle().equals(order.getTitle()) &&
                getServiceT().equals(order.getServiceT()) &&
                getServiceType_id().equals(order.getServiceType_id()) &&
                getDescription().equals(order.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getServiceT(), getServiceType_id(), getDescription());
    }
}
