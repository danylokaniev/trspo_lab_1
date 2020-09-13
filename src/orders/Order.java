package orders;

import people.Client;
import people.Manager;
import people.Repair;

import java.util.ArrayList;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Order {

    private final Repair repair;
    private final Manager manager;
    private final Client client;

    private final String id;
    private int totalPrice = 0;

    private boolean isFinished;
    ArrayList<Integer> setOfTodos;

    public Order(Repair repair, Manager manager, Client client) {
        setOfTodos = new ArrayList<>();

        this.repair = repair;
        this.manager = manager;
        this.client = client;
        this.id = UUID.randomUUID().toString();
        this.isFinished = false;
    }

    public String getId() {
        return id;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void toggleFinishedState() {
        isFinished = !this.isFinished;
        System.out.println("Состояние заказа изменено");
    }

    public void getOrderDetails(TodosList TodosList) {

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

    public void createSetOfTodos(String stringByTodosList, TodosList TodosList) {
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
}
