package people;

import services.JobService;
import services.ValidateService;

import java.util.Scanner;
import java.util.UUID;

public final class Repair implements People {

    private final int salary;
    private final int age;
    private final String id;

    private final String name;
    private boolean isFree;

    public Repair() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("(Repair) Введите имя: ");
        this.name = scanner.nextLine();

        System.out.println("Введите возраст: ");
        this.age = ValidateService.getCorrectNumber(100);

        System.out.println("Введите зарплату: ");
        this.salary = ValidateService.getCorrectNumber(5000);

        this.isFree = true;
        this.id = UUID.randomUUID().toString();

        JobService.addRepair(this);
        System.out.println("Ремонтник добавлен");
    }

    public Repair(int salary, int age, String name) {

        this.age = age;
        this.salary = salary;
        this.name = name;
        this.isFree = true;
        this.id = UUID.randomUUID().toString();

        JobService.addRepair(this);
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean getFreeState() {
        return isFree;
    }

    public void toggleFreeState() {
        isFree = !this.isFree;
    }

    @Override

    public String toString() {
        return ("\n(Repair) Имя: " + name + "\n\t  Зарплата: " + salary
                + "\n\t   Возраст: " + age + "\n\t  Свободен: " + (isFree ? "Да" : "Нет")
                + "\n\t      ID: " + id);
    }
}
