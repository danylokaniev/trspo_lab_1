package services;

import peoples.Client;

import java.util.TreeSet;

public class ClientService {

    private static TreeSet<Client> listOfClients = new TreeSet<>();

    public static void addClient(Client client) {
        listOfClients.add(client);
    }

    public static void removeClient(Client client) {
        listOfClients.remove(client);
    }

    public static Client getClientByName(String name) {
        for (Client client : listOfClients) {

            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

}
