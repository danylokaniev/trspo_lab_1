package peoples;

import services.ValidateService;

import java.util.Scanner;

public class Manager implements People {

    private int salary;
    private String name;
    private final int id;
    private static int amount = 0;

    public Manager() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("(Manager) Введите имя: ");
        this.name = scanner.nextLine();

        System.out.println("Введите зарплату: ");
        this.salary = ValidateService.getCorrectNumber(7000);

        this.id = amount;
        amount++;
    }

    public Manager(int salary, String name) {
        this.salary = salary;
        this.name = name;
        this.id = amount;
        amount++;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAmount() {
        return amount;
    }

    public void printInfo() {
        System.out.println("\n(Manager) Имя: " + name);
        System.out.println("\t     Зарплата: " + salary);
    }
}
