package com.company;

import orders.Order;
import orders.TodoItem;
import orders.TodosList;
import peoples.Client;
import peoples.Manager;
import peoples.Repair;
import services.ClientService;
import services.JobService;
import services.OrderService;
import services.ValidateService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TodosList.addTodos();

        new Client("Пушкина 3", "Вася Пупкин");
        new Client("Майдан Независимости 12", "Всеволод Баженов");
        new Client("Горбачего 15", "Григорий Анкурасян");
        new Client("Птушкина 4", "Владимир Горбачев");

        new Repair(1750, 33, "Александр Шакалов");
        new Repair(2000, 40, "Григорий Лупс");
        new Repair(2150, 43, "Аргентин Скворечник");

        Manager manager = new Manager(2700, "Сергей Скворнов");

        int i = -1;

        while (i != 11) {
            i = printMenu();
            switch (i) {
                case 0:
                    ClientService.printFullListOfClients();
                    break;
                case 1:
                    new Client();
                    break;
                case 2:
                    System.out.println("Введите номер клиента, которого желаете удалить:");
                    int clientId = ValidateService.getCorrectNumber(Client.getAmount());
                    ClientService.removeClientById(clientId);
                    break;
                case 3:
                    JobService.printFullListOfReceipes();
                    break;
                case 4:
                    new Repair();
                    break;
                case 5:
                    System.out.println("Введите номер ремонтника, которого желаете удалить:");
                    int repairId = ValidateService.getCorrectNumber(Repair.getAmount());
                    JobService.removeRepairById(repairId);
                    break;
                case 6:
                    manager.printInfo();
                    break;
                case 7:
                    OrderService.printOrders();
                    break;
                case 8:
                    createOrder(manager);
                    break;
                case 9:
                    if (Order.getAmount() == 0) {
                        System.out.println("Список заказов пуст.");

                    } else {
                        System.out.println("Введите номер заказа, который желаете удалить:");
                        int orderId = ValidateService.getCorrectNumber(Order.getAmount());
                        OrderService.removeOrderById(orderId);
                    }
                    break;
                case 10:
                    if (Order.getAmount() == 0) {
                        System.out.println("Список заказов пуст.");
                    } else {
                        OrderService.printOrders();
                        System.out.println("Введите номер заказа, который желаете удалить:");
                        int orderToggleId = ValidateService.getCorrectNumber(Order.getAmount());
                        OrderService.getOrderById(orderToggleId).toggleFinishedState();
                    }

                    break;
                default:
                    break;
            }
        }

    }

    public static int printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("Меню: ");
        System.out.println("0. Список клиентов");
        System.out.println("1. Добавить клиента");
        System.out.println("2. Удалить клиента");
        System.out.println("3. Список ремонтников");
        System.out.println("4. Добавить ремонтника");
        System.out.println("5. Удалить ремонтника");
        System.out.println("6. Список менеджеров");
        System.out.println("7. Список заказов");
        System.out.println("8. Создать заказ");
        System.out.println("9. Удалить заказ");
        System.out.println("10. Сменить состояние заказа");
        System.out.println("11. Завершить");
        System.out.println("--------------------------------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Что желаете узнать? ");
        return scanner.nextInt();
    }

    public static void createOrder(Manager manager) {

        Scanner scanner = new Scanner(System.in);

        ClientService.printFullListOfClients();
        System.out.println("Введите номер клиента:");

        int clientId = ValidateService.getCorrectNumber(Client.getAmount());
        Client client = ClientService.getClientById(clientId);

        System.out.println("На заказ будет призначен первый свободный ремонтник, а именно: ");

        Repair freeRepair = JobService.getFirstFreeRepair();

        if (freeRepair == null) {
            System.out.println("К сожалению, нет свободных ремонтников");
            System.out.println("Подождите пока хотя бы один освободится");

            return;
        }
        System.out.println("\n----------");
        freeRepair.printInfo();
        System.out.println("\n----------\n");
        Order newOrder = new Order(freeRepair, manager, client);

        System.out.println("Вот список доступных услуг:");
        TodosList.printSetOfTodos();
        System.out.println("В одну строку введите номера услуг, которые хотите заказать.\n" +
                "Все некорректные данные будут пропущены.");
        String setOfTodos = scanner.nextLine();
        newOrder.createSetOfTodos(setOfTodos);
        OrderService.addOrder(newOrder);
        System.out.println("Заказ создан");
    }
}
