package by.it.academy.ob.service;

import by.it.academy.ob.model.Model;

import java.util.List;

public interface ServiceInterface {
        List<Model> getListServices();
        void addNewService(Model task);
        void deliteService1(Long id);
        void update(Model model);
}
