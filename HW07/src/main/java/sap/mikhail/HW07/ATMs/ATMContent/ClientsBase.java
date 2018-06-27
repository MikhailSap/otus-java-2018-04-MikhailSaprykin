package sap.mikhail.HW07.ATMs.ATMContent;

import java.util.HashMap;


public class ClientsBase {
    private static ClientsBase clientsBase = new ClientsBase();
    private HashMap<Integer, Client> clients = new HashMap<Integer, Client>();

    private ClientsBase() {
    }

    public static ClientsBase getClientsBase() {
        return clientsBase;
    }

    public void addClient(int id, int balance) {
        clients.put(id, new Client(id, balance));
    }

    public Client getClietn(int id) {
        if (clients.containsKey(id)) {
            return clients.get(id);
        }
        else
            return null;
    }
}
