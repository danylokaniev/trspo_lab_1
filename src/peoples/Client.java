package peoples;

import services.ClientService;

import java.util.Scanner;

public class Client implements Comparable<Client>, People {

    private String address;
    private String name;
    private final int id;
    private static int amount = 0;

    public Client() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("(Client) Введите имя: ");
        this.name = scanner.nextLine();

        System.out.println("Введите адрес: ");
        this.address = scanner.nextLine();

        this.id = amount;
        amount++;

        ClientService.addClient(this);
    }

    public Client(String address, String name) {

        this.address = address;
        this.name = name;
        this.id = amount;
        amount++;

        ClientService.addClient(this);
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("\n(Client) Имя: " + name);
        System.out.println("\t       Адрес: " + address);
        System.out.println("\t          ID: " + id);
    }

    public static int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Client o) {
        return o.getId();
    }
}
