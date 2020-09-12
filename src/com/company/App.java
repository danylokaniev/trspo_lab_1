package com.company;

import orders.Order;
import orders.TodosList;
import people.Client;
import people.Manager;
import people.Repair;
import services.*;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void startApp() {

        int userChoice = -1;

        while (userChoice < 14) {

            userChoice = printMenu();

            switch (userChoice) {

                case 1:
                    ClientService.printFullListOfClients();
                    break;

                case 2:
                    new Client();
                    break;

                case 3:
                    System.out.println("Введите номер клиента, которого желаете удалить:");
                    int clientId = ValidateService.getCorrectNumber(ClientService.getAmount());
                    ClientService.removeClientById(clientId);
                    break;

                case 4:
                    JobService.printFullListOfReceipes();
                    break;

                case 5:
                    new Repair();
                    break;

                case 6:
                    System.out.println("Введите номер ремонтника, которого желаете удалить:");
                    int repairId = ValidateService.getCorrectNumber(JobService.getAmount());
                    JobService.removeRepairById(repairId);
                    break;

                case 7:
                    ManagerService.printFullListOfManagers();
                    break;

                case 8:
                    new Manager();
                    break;

                case 9:
                    System.out.println("Введите номер менеджера, которого желаете удалить:");
                    int managerID = ValidateService.getCorrectNumber(ManagerService.getAmount());
                    ManagerService.removeManagerById(managerID);
                    break;

                case 10:
                    OrderService.printOrders();
                    break;

                case 11:
                    createOrder();
                    break;

                case 12:
                    if (OrderService.getAmount() == 0) {
                        System.out.println("Список заказов пуст.");

                    } else {
                        System.out.println("Введите номер заказа, который желаете удалить:");
                        int orderId = ValidateService.getCorrectNumber(OrderService.getAmount());
                        OrderService.removeOrderById(orderId);
                    }
                    break;

                case 13:
                    if (OrderService.getAmount() == 0) {
                        System.out.println("Список заказов пуст.");
                    } else {
                        OrderService.printOrders();
                        System.out.println("Введите номер заказа, состояние которого хотите изменить:");
                        int orderToggleId = ValidateService.getCorrectNumber(OrderService.getAmount());
                        Objects.requireNonNull(OrderService.getOrderById(orderToggleId)).toggleFinishedState();
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
        System.out.println("1. Список клиентов");
        System.out.println("2. Добавить клиента");
        System.out.println("3. Удалить клиента");
        System.out.println("4. Список ремонтников");
        System.out.println("5. Добавить ремонтника");
        System.out.println("6. Удалить ремонтника");
        System.out.println("7. Список менеджеров");
        System.out.println("8. Добавить менеджера");
        System.out.println("9. Удалить менеджеров");
        System.out.println("10. Список заказов");
        System.out.println("11. Создать заказ");
        System.out.println("12. Удалить заказ");
        System.out.println("13. Сменить состояние заказа");
        System.out.println("14. Завершить");
        System.out.println("--------------------------------------------");

        System.out.println("Что желаете узнать? ");
        return ValidateService.getCorrectNumber(15);
    }

    public static void createOrder() {

        Scanner scanner = new Scanner(System.in);

        ClientService.printFullListOfClients();
        System.out.println("\n\tВведите номер клиента:");

        int clientId = ValidateService.getCorrectNumber(ClientService.getAmount());
        Client client = ClientService.getClientById(clientId);

        ManagerService.printFullListOfManagers();
        System.out.println("\n\tВведите номер менеджера:");

        int managerID = ValidateService.getCorrectNumber(ManagerService.getAmount());
        Manager manager = ManagerService.getManagerById(managerID);

        System.out.println("\n\tНа заказ будет призначен первый свободный ремонтник, а именно: ");

        Repair freeRepair = JobService.getFirstFreeRepair();

        if (freeRepair == null) {
            System.out.println("\n\tК сожалению, нет свободных ремонтников");
            System.out.println("\n\tПодождите пока хотя бы один освободится");

            return;
        }

        System.out.println("\n----------");
        System.out.println(freeRepair);
        System.out.println("\n----------\n");

        Order newOrder = new Order(freeRepair, manager, client);

        System.out.println("\n\tВот список доступных услуг:");
        TodosList.printSetOfTodos();

        System.out.println("\n\tВ одну строку введите номера услуг, которые хотите заказать.\n" +
                "Все некорректные данные будут пропущены.");

        String setOfTodos = scanner.nextLine();
        newOrder.createSetOfTodos(setOfTodos);

        OrderService.addOrder(newOrder);
        System.out.println("Заказ создан");
    }
}
