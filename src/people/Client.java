package people;

import services.ClientService;

import java.util.Scanner;

public final class Client implements Comparable<Client>, People {

    private final String address;
    private final String name;

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

    public String getName() {
        return name;
    }

    public static int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Client o) {
        return o.getId();
    }

    public String toString() {
        return ("\n(Client) Имя: " + name + "\n\t   Адрес: " + address + "\n\t      ID: " + id);
    }

}
