package services;

import orders.Order;
import orders.TodosList;

import java.util.ArrayList;

public final class OrderService {

    private final ArrayList<Order> listOfOrders;

    public OrderService() {
        listOfOrders = new ArrayList<>();
    }

    public void addOrder(Order Order) {
        listOfOrders.add(Order);
    }

    public void removeOrderById(int id) {
        listOfOrders.remove(id);
        System.out.println("Заказ удален");
    }

    public Order getOrderById(int id) {
        return listOfOrders.get(id);
    }

    public int getAmount() {
        return listOfOrders.size();
    }

    public int countFinishedOrders() {
        int amount = 0;

        for (Order Order : listOfOrders) {

            if (Order.isFinished()) {
                amount++;
            }
        }
        return amount;
    }

    public void printOrders(TodosList TodosList) {
        if (listOfOrders.size() == 0) {
            System.out.println("Список заказов пуст.");
            return;
        }

        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println("\n#" + i);
            listOfOrders.get(i).getOrderDetails(TodosList);
        }
    }
}
