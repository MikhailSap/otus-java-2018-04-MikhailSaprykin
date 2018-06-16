package sap.mikhail.HW07.ATM00;

import sap.mikhail.HW07.remoteInterface.ATMRemoteInterface;

import java.rmi.RemoteException;

public class ATMRemoteServices implements ATMRemoteInterface{
    public int getBalance() throws RemoteException {
        return ATM.getATM().getBalance();
    }

    public String setDefault() throws RemoteException {
        return ATM.getATM().setDefault();
    }
}
