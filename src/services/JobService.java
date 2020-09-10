package services;

import peoples.Repair;

import java.util.Comparator;
import java.util.LinkedHashSet;

public class JobService implements Comparator<Repair> {

    private static final LinkedHashSet<Repair> listOfRepairs = new LinkedHashSet<>();

    public static void addRepair(Repair repair) {
        listOfRepairs.add(repair);
        System.out.println("Ремонтник добавлен");
    }

    public static void removeRepair(Repair repair) {
        listOfRepairs.remove(repair);
    }

    public static void removeRepairById(int id) {
        for (Repair Repair : listOfRepairs) {
            if (Repair.getId() == id) {
                listOfRepairs.remove(Repair);
                System.out.println("Ремонтник удален");
                return;
            }
        }
    }

    public static Repair getRepairById(int id) {
        for (Repair repair : listOfRepairs) {

            if (repair.getId() == id) {
                return repair;
            }
        }

        return null;
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
        for (Repair repair : listOfRepairs) {
            repair.printInfo();
        }
    }

    @Override
    public int compare(Repair repair1, Repair repair2) {
        return repair1.getSalary() - repair2.getSalary();
    }
}
