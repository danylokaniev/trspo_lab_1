package services;

import people.Client;

import java.util.ArrayList;

public final class ClientService {

    private final ArrayList<Client> listOfClients;

    public ClientService() {
        listOfClients = new ArrayList<>();
    }

    public void addClient(Client client) {
        listOfClients.add(client);
    }

    public void removeClientById(int id) {
        listOfClients.remove(id);
    }

    public Client getClientById(int id) {
        return listOfClients.get(id);
    }

    public int getAmount() {
        return listOfClients.size();
    }


    public Client getClientByName(String name) {
        for (Client client : listOfClients) {

            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    public void printFullListOfClients() {
        if (listOfClients.size() == 0) {
            System.out.println("Список клиентов пуст.");
            return;
        }

        for (int i = 0; i < listOfClients.size(); i++) {
            System.out.println("#" + i + listOfClients.get(i));
        }
    }
}
