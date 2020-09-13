import App.App;
import orders.TodosList;
import people.Client;
import people.Manager;
import people.Repair;
import services.ClientService;
import services.JobService;
import services.ManagerService;
import services.OrderService;

public class Main {

    public static void main(String[] args) {
        TodosList TodosList = new TodosList();
        ClientService ClientService = new ClientService();
        JobService JobService = new JobService();
        OrderService OrderService = new OrderService();
        ManagerService ManagerService = new ManagerService();

        Main.createClients(ClientService);
        Main.createRepairs(JobService);
        Main.createManagers(ManagerService);

        App.startApp(ClientService, JobService, ManagerService, OrderService, TodosList);
    }

    public static void createClients(ClientService ClientService) {
        new Client("Пушкина 3", "Вася Пупкин", ClientService);
        new Client("Майдан Независимости 12", "Всеволод Баженов", ClientService);
        new Client("Горбачего 15", "Григорий Анкурасян", ClientService);
        new Client("Птушкина 4", "Владимир Горбачев", ClientService);
    }

    public static void createRepairs(JobService JobService) {
        new Repair(1750, 33, "Александр Шакалов", JobService);
        new Repair(2000, 40, "Григорий Лупс", JobService);
        new Repair(2150, 43, "Аргентин Скворечник", JobService);
    }

    public static void createManagers(ManagerService ManagerService) {
        new Manager(2700, "Сергей Скворнов", ManagerService);
        new Manager(3500, "Анастасия Васнецова", ManagerService);
    }
}
