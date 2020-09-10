package services;


import orders.Order;

import java.util.TreeSet;

public class OrderService {

    private static TreeSet<Order> listOfOrders = new TreeSet<>();

    public static void addOrder(Order Order) {
        listOfOrders.add(Order);
    }

    public static void removeOrder(Order Order) {
        listOfOrders.remove(Order);
    }

    public static Order getOrderById(int id) {
        for (Order Order : listOfOrders) {

            if (Order.getId() == id) {
                return Order;
            }
        }
        return null;
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


}
