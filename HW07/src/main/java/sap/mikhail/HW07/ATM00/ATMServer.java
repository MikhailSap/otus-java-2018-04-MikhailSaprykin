package sap.mikhail.HW07.ATM00;

import sap.mikhail.HW07.remoteInterface.ATMRemoteInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ATMServer implements Runnable{
    public void run() {
        ATMRemoteInterface atmRemoteServices = new ATMRemoteServices();

        try {
            ATMRemoteInterface stub =(ATMRemoteInterface) UnicastRemoteObject.exportObject(atmRemoteServices, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Remote Service", stub);
            System.out.println("Server 00 has started..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
