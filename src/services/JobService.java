package services;

import people.Repair;

import java.util.ArrayList;

public final class JobService {

    private static final ArrayList<Repair> listOfRepairs = new ArrayList<>();

    public static void addRepair(Repair repair) {
        listOfRepairs.add(repair);
    }

    public static void removeRepairById(int id) {
        listOfRepairs.remove(id);
        System.out.println("Ремонтник удален");
    }

    public static int getAmount() {
        return listOfRepairs.size();
    }

    public static Repair getRepairById(int id) {
        return listOfRepairs.get(id);
    }

    public static Repair getFirstFreeRepair() {
        for (Repair repair : listOfRepairs) {

            if (repair.getFreeState()) {
                repair.toggleFreeState();

                return repair;
            }
        }

        return null;
    }

    public static void printFullListOfReceipes() {

        if (listOfRepairs.size() == 0) {
            System.out.println("Список ремонтников пуст.");
            return;
        }

        for (int i = 0; i < listOfRepairs.size(); i++) {
            System.out.println("#" + i + listOfRepairs.get(i));
        }
    }
}
