package sap.mikhail.HW07.remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ATMRemoteInterface extends Remote {
    int getBalance() throws RemoteException;
    String setDefault() throws RemoteException;
}
