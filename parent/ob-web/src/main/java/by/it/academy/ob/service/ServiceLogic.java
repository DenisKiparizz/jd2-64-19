package by.it.academy.ob.service;

    import by.it.academy.ob.model.Model;
    import java.util.ArrayList;
import java.util.List;

public class ServiceLogic implements ServiceInterface {
    public static final ServiceInterface INSTANCE = new ServiceLogic();
    public final List<Model> list;
    private Long id;
    private int nomber;



    public static ServiceInterface getService() {
        return INSTANCE;
    }

    public ServiceLogic() {
        id=100L;
        list = new ArrayList<>();
    }

    @Override
    public List<Model> getListServices() {
        return list;
    }

    @Override
    public void addNewService(Model task) {
        task.setNomber(nomber++);
        task.setId(id++);
        list.add(task);
    }
//    @Override
//    public void deliteService(Long id) {
//        for (Model a : list) {
//            if (a.getId()==id) {
//                list.remove(a);
//            }
//        }
//    }
            @Override
            public void update (Model model){
                for (Model a: list) {
                    if (a.getId().equals(model.getId())) {
                        a.setNomber(nomber++);
                        a.setId(id++);
                        a.setNameOfService(model.getNameOfService());
                        a.setDescription(model.getDescription());
                    }
                }
            }

            @Override
            public void deliteService1 (Long id){
                list.removeIf(a -> a.getId().equals(id));
            }

        }
