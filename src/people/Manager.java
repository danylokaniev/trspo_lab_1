package people;

import services.ValidateService;

import java.util.Scanner;

public final class Manager implements People {

    private final int salary;
    private final String name;
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

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override

    public String toString() {
        return ("\n(Manager) Имя: " + name + "\n\t  Зарплата: " + salary);
    }
}
