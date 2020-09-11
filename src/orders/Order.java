package orders;

import peoples.Client;
import peoples.Manager;
import peoples.Repair;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order implements Comparable<Order> {
    private Repair repair;
    private Manager manager;
    private final Client client;

    private final int id;
    private int totalPrice = 0;
    private static int amount = 0;

    private boolean isFinished;
    HashSet<Integer> setOfTodos = new HashSet<>();

    public Order(Repair repair, Manager manager, Client client) {
        this.repair = repair;
        this.manager = manager;
        this.client = client;
        this.id = amount;
        amount++;
        this.isFinished = false;
    }

    public Repair getRepair() {
        return repair;
    }


    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void toggleFinishedState() {
        isFinished = !this.isFinished;
        System.out.println("Состояние заказа изменено");
    }


    public void addTodo(int todoId) {
        setOfTodos.add(todoId);
    }

    public void deleteTodo(int todoId) {
        setOfTodos.remove(todoId);
    }


    public void printInfo() {

        System.out.println("\nНомер заказа - " + id);
        System.out.println("Имя клиента - " + client.getName());
        System.out.println("Имя менеджера - " + manager.getName());
        System.out.println("Имя ремонтника - " + repair.getName());
        System.out.println("Завершен: " + (isFinished ? "Да" : "Нет"));
        System.out.println("Список услуг: ");

        if (setOfTodos.isEmpty()) {
            System.out.println("Список услуг пуст");
        } else {
            for (int id : setOfTodos) {
                TodosList.getInfoByTodoId(id);
            }
        }

        System.out.println("Сумма к оплате: " + totalPrice + "\n");
    }

    public void createSetOfTodos(String stringByTodosList) {
        int maxTodoId = TodosList.getAmountOfTodos();

        String pattern = "\\b(\\d+)\\b";

        Pattern regex = Pattern.compile(pattern);

        Matcher mathces = regex.matcher(stringByTodosList);

        while (mathces.find()) {
            int id = Integer.parseInt(mathces.group());
            if (id >= 0 && id < maxTodoId) {
                setOfTodos.add(id);
                totalPrice += TodosList.getPriceByTodoId(id);
            }
        }
    }

    public static int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Order order) {
        return order.getId();
    }
}
