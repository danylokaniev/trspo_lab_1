package com.company;

import orders.TodoItem;
import orders.TodosList;
import peoples.Manager;
import peoples.Repair;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Repair repair = new Repair();

        // Добавить в список услуги
        TodosList.addTodos();
        TodosList.printFullTodoList();

        TodosList.addTodo(new TodoItem(TodosList.getAmountOfTodos(), 150, "Повесить люстру"));
        TodosList.addTodo(new TodoItem(TodosList.getAmountOfTodos(), 1500, "Сделать крышу"));

        TodosList.printFullTodoList();

        Repair repair1 = new Repair(1500, 40, "Dan");
        repair1.printInfo();
        repair1.toggleFreeState();
        repair1.printInfo();

    }
}
