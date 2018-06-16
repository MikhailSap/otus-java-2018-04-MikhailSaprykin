package sap.mikhail.HW07.ATMDepartment;

import sap.mikhail.HW07.remoteInterface.ATMRemoteInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteController {
    private ATMRemoteInterface remoteController;

    public RemoteController(String ip, int port) {
        try {
            Registry registry = LocateRegistry.getRegistry(ip, port);
            remoteController = (ATMRemoteInterface) registry.lookup("Remote Service");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ATMRemoteInterface getRemoteController() {
        return remoteController;
    }
}
