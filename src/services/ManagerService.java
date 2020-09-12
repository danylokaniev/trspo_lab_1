package services;

import people.Manager;

import java.util.ArrayList;

public class ManagerService {
    private static final ArrayList<Manager> listOfManagers = new ArrayList<>();

    public static void addManager(Manager manager) {
        listOfManagers.add(manager);
    }

    public static void removeManagerById(int id) {
        listOfManagers.remove(id);
    }

    public static Manager getManagerById(int id) {
        return listOfManagers.get(id);
    }

    public static int getAmount() {
        return listOfManagers.size();
    }


    public static Manager getManagerByName(String name) {
        for (Manager manager : listOfManagers) {

            if (manager.getName().equals(name)) {
                return manager;
            }
        }
        return null;
    }

    public static void printFullListOfManagers() {
        if (listOfManagers.size() == 0) {
            System.out.println("Список менеджеров пуст.");
            return;
        }

        for (int i = 0; i < listOfManagers.size(); i++) {
            System.out.println("#" + i+ listOfManagers.get(i));
        }
    }
}
