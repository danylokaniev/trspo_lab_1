package services;

import orders.Order;

import java.util.ArrayList;

public final class OrderService {

    private static final ArrayList<Order> listOfOrders = new ArrayList<>();

    public static void addOrder(Order Order) {
        listOfOrders.add(Order);
    }

    public static void removeOrderById(int id) {
        listOfOrders.remove(id);
        System.out.println("Заказ удален");
    }

    public static Order getOrderById(int id) {
        return listOfOrders.get(id);
    }

    public static int getAmount() {
        return listOfOrders.size();
    }

    public static int countFinishedOrders() {
        int amount = 0;

        for (Order Order : listOfOrders) {

            if (Order.isFinished()) {
                amount++;
            }
        }
        return amount;
    }

    public static void printOrders() {
        if (listOfOrders.size() == 0) {
            System.out.println("Список заказов пуст.");
            return;
        }

        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println("\n#" + i);
            listOfOrders.get(i).getOrderDetails();
        }
    }
}
