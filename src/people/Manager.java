package people;

import services.ManagerService;
import services.ValidateService;

import java.util.Scanner;
import java.util.UUID;

public final class Manager implements People {

    private final int salary;
    private final String name;
    private final String id;

    public Manager() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("(Manager) Введите имя: ");
        this.name = scanner.nextLine();

        System.out.println("Введите зарплату: ");
        this.salary = ValidateService.getCorrectNumber(7000);

        this.id = UUID.randomUUID().toString();

        ManagerService.addManager(this);
        System.out.println("Менеджер добавлен");
    }

    public Manager(int salary, String name) {
        this.salary = salary;
        this.name = name;
        this.id = UUID.randomUUID().toString();

        ManagerService.addManager(this);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override

    public String toString() {
        return ("\n(Manager) Имя: " + name + "\n\t  Зарплата: " + salary);
    }
}
