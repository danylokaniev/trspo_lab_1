package peoples;

import services.JobService;
import services.ValidateService;

import java.util.Scanner;

public class Repair implements Comparable<Repair>, People {

    private int salary;
    private int age;
    private final int id;
    private static int amount = 0;

    private String name;
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
        this.id = amount;
        amount++;

        JobService.addRepair(this);
    }

    public Repair(int salary, int age, String name) {

        this.age = age;
        this.salary = salary;
        this.name = name;
        this.isFree = true;
        this.id = amount;
        amount++;

        JobService.addRepair(this);
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getFreeState() {
        return isFree;
    }

    public void toggleFreeState() {
        isFree = !this.isFree;
    }


    public void printInfo() {
        System.out.println("\n(Repair) Имя: " + name);
        System.out.println("\t  Зарплата: " + salary);
        System.out.println("\t   Возраст: " + age);
        System.out.println("\t  Свободен: " + (isFree ? "Да" : "Нет"));
        System.out.println("\t        ID: " + id);
    }

    public static int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Repair repair) {
        return repair.getSalary();
    }
}
