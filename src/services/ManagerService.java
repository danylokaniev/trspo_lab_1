package services;

import people.Manager;

import java.util.ArrayList;

public class ManagerService {
    private final ArrayList<Manager> listOfManagers;

    public ManagerService() {
        listOfManagers = new ArrayList<>();
    }

    public void addManager(Manager manager) {
        listOfManagers.add(manager);
    }

    public void removeManagerById(int id) {
        listOfManagers.remove(id);
    }

    public Manager getManagerById(int id) {
        return listOfManagers.get(id);
    }

    public int getAmount() {
        return listOfManagers.size();
    }


    public Manager getManagerByName(String name) {
        for (Manager manager : listOfManagers) {

            if (manager.getName().equals(name)) {
                return manager;
            }
        }
        return null;
    }

    public void printFullListOfManagers() {
        if (listOfManagers.size() == 0) {
            System.out.println("Список менеджеров пуст.");
            return;
        }

        for (int i = 0; i < listOfManagers.size(); i++) {
            System.out.println("#" + i + listOfManagers.get(i));
        }
    }
}
