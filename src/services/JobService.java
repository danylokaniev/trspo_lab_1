package services;

import people.Repair;

import java.util.ArrayList;

public final class JobService {

    private final ArrayList<Repair> listOfRepairs;

    public JobService() {
        listOfRepairs = new ArrayList<>();
    }

    public void addRepair(Repair repair) {
        listOfRepairs.add(repair);
    }

    public void removeRepairById(int id) {
        listOfRepairs.remove(id);
        System.out.println("Ремонтник удален");
    }

    public int getAmount() {
        return listOfRepairs.size();
    }

    public Repair getRepairById(int id) {
        return listOfRepairs.get(id);
    }

    public Repair getFirstFreeRepair() {
        for (Repair repair : listOfRepairs) {

            if (repair.getFreeState()) {
                repair.toggleFreeState();

                return repair;
            }
        }

        return null;
    }

    public void printFullListOfReceipes() {

        if (listOfRepairs.size() == 0) {
            System.out.println("Список ремонтников пуст.");
            return;
        }

        for (int i = 0; i < listOfRepairs.size(); i++) {
            System.out.println("#" + i + listOfRepairs.get(i));
        }
    }
}
