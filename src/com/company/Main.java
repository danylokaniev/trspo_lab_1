package com.company;

import orders.Order;
import orders.TodoItem;
import orders.TodosList;
import peoples.Manager;
import peoples.Repair;
import validate.validateInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Repair repair = new Repair();

        // Добавить в список услуги
        TodosList.addTodos();
        TodosList.printFullTodoList();

        TodosList.addTodo(new TodoItem(TodosList.getAmountOfTodos() , 150, "Повесить люстру"));
        TodosList.addTodo(new TodoItem(TodosList.getAmountOfTodos() , 1500, "Сделать крышу"));

        TodosList.printFullTodoList();

   }
}
