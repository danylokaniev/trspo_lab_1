package services;

import people.Client;

import java.util.Comparator;
import java.util.LinkedHashSet;

public final class ClientService implements Comparator<Client> {

    private static final LinkedHashSet<Client> listOfClients = new LinkedHashSet<>();

    public static void addClient(Client client) {
        listOfClients.add(client);
        System.out.println("Клиент добавлен");
    }

    public static void removeClientById(int id) {
        for (Client client : listOfClients) {

            if(client.getId() == id){
                listOfClients.remove(client);
                System.out.println("Клиент удален");

                return;
            }
        }

    }

    public static Client getClientById(int id) {
        for (Client client : listOfClients) {

            if (client.getId() == id) {
                return client;
            }
        }

        return null;
    }


    public static Client getClientByName(String name) {
        for (Client client : listOfClients) {

            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    public static void printFullListOfClients() {
        for (Client client : listOfClients) {
            System.out.println(client);
        }
    }

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getId() - o2.getId();
    }
}
