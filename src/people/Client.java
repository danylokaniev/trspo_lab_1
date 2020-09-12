package people;

import services.ClientService;

import java.util.Scanner;
import java.util.UUID;

public final class Client implements People {

    private final String address;
    private final String name;

    private final String id;

    public Client() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("(Client) Введите имя: ");
        this.name = scanner.nextLine();

        System.out.println("Введите адрес: ");
        this.address = scanner.nextLine();

        this.id = UUID.randomUUID().toString();

        ClientService.addClient(this);
        System.out.println("Клиент добавлен");
    }

    public Client(String address, String name) {

        this.address = address;
        this.name = name;
        this.id = UUID.randomUUID().toString();

        ClientService.addClient(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override

    public String toString() {
        return ("\n(Client) Имя: " + name + "\n\t   Адрес: " + address + "\n\t      ID: " + id);
    }

}
