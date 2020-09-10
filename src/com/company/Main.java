package com.company;

import orders.Order;
import orders.TodosList;
import peoples.Manager;
import peoples.Repair;
import validate.validateInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodosList.printFullTodosList();
        Manager manager = new Manager();
        Repair repair = new Repair();
//        int a = validateInput.getCorrectTodoNumber();
//        System.out.println(TodosList.getTodoByCode(a).getName());
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Order order = new Order(repair, manager);

        order.createSetOfTodos(str);
        order.addTodo(validateInput.getCorrectTodoNumber());
        order.printSetOfTodos();
        order.addTodo(validateInput.getCorrectTodoNumber());
        order.printSetOfTodos();
        order.deleteTodo(validateInput.getCorrectTodoNumber());
        order.printSetOfTodos();
        order.deleteTodo(validateInput.getCorrectTodoNumber());
        order.printSetOfTodos();




    }
}
