package services;

import people.Client;

import java.util.ArrayList;

public final class ClientService {

    private static final ArrayList<Client> listOfClients = new ArrayList<>();

    public static void addClient(Client client) {
        listOfClients.add(client);
    }

    public static void removeClientById(int id) {
        listOfClients.remove(id);
    }

    public static Client getClientById(int id) {
        return listOfClients.get(id);
    }

    public static int getAmount() {
        return listOfClients.size();
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
        if (listOfClients.size() == 0) {
            System.out.println("Список клиентов пуст.");
            return;
        }

        for (int i = 0; i < listOfClients.size(); i++) {
            System.out.println("#" + i + listOfClients.get(i));
        }
    }
}
