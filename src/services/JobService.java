package services;

import orders.TodoItem;
import peoples.Repair;

import java.util.TreeSet;

public class JobService {
    private static final TreeSet<Repair> listOfRepairs = new TreeSet<>();

    public static void addRepair(Repair repair) {
        listOfRepairs.add(repair);
    }

    public static void removeRepair(Repair repair) {
        listOfRepairs.remove(repair);
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

}
