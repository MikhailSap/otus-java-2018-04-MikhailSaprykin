package sap.mikhail.HW06;

import java.util.HashMap;


public class ClientsBase {
    private static ClientsBase clientsBase = new ClientsBase();
    private HashMap<Integer, Client> clients = new HashMap<Integer, Client>();

    private ClientsBase() {
        Client clientOne = new Client(12345, 6650);
        Client clientTwo = new Client(54321, 5432);
        Client clientThree = new Client(33333, 0);
        Client clientFour = new Client(00000, 7000);
        clients.put(clientOne.getId(), clientOne);
        clients.put(clientTwo.getId(), clientTwo);
        clients.put(clientThree.getId(), clientThree);
        clients.put(clientFour.getId(), clientFour);
    }

    public static ClientsBase getClientsBase() {
        return clientsBase;
    }

    public Client getClietn(int id) {
        if (clients.containsKey(id)) {
            return clients.get(id);
        }
        else
            return null;
    }
}
