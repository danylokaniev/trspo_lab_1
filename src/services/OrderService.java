package services;

import orders.Order;

import java.util.Comparator;
import java.util.LinkedHashSet;

public class OrderService implements Comparator<Order> {

    private static final LinkedHashSet<Order> listOfOrders = new LinkedHashSet<>();

    public static void addOrder(Order Order) {
        listOfOrders.add(Order);
    }

    public static void removeOrder(Order Order) {
        listOfOrders.remove(Order);
    }

    public static void removeOrderById(int id) {
        for (Order order : listOfOrders) {

            if (order.getId() == id) {
                listOfOrders.remove(order);
                System.out.println("Заказ удален");
                return;
            }
        }
    }

    public static Order getOrderById(int id) {
        for (Order order : listOfOrders) {

            if (order.getId() == id) {
                return order;
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

    public static void printOrders() {
        if (Order.getAmount() == 0) {
            System.out.println("Список заказов пуст.");
            return;
        }
        for (Order order : listOfOrders) {
            order.printInfo();
        }
    }


    @Override
    public int compare(Order o1, Order o2) {
        return o1.getId() - o2.getId();
    }
}
