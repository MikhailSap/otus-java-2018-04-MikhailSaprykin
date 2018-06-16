package sap.mikhail.HW07.ATMDepartment;

import sap.mikhail.HW07.remoteInterface.ATMRemoteInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class ATMDepartment {
    private ATMRemoteInterface remoteController;
    private HashMap<Integer, ATM> atmBase = ATMBase.getATMBase().getBase();


    public void getBalancesFromAllATM() {
        atmBase.forEach(
                (id, atm)->{
                    getBalanceATM(id);
                }
        );
    }

    public void setDefaultAllATM() {
        atmBase.forEach(
                (id, atm)->{
                    setDefaultATM(id);
                }
        );
    }

    public void getBalanceATM(int id) {
        ATM atm = atmBase.get(id);
        remoteController = new RemoteController(atm.getIp(), atm.getPort()).getRemoteController();
        try {
            atm.setBalance(remoteController.getBalance());
        } catch (Exception e) {e.printStackTrace();}
    }


    public void setDefaultATM(int id) {
        ATM atm = atmBase.get(id);
        remoteController = new RemoteController(atm.getIp(), atm.getPort()).getRemoteController();
        try {
            System.out.println(remoteController.setDefault());
        } catch (Exception e) {e.printStackTrace();}
    }

    public int getAllMoney() {
        int sum = 0;
        Collection<ATM> atms = atmBase.values();

        for (ATM atm : atms)
            sum += atm.getBalance();
        return sum;
    }
}
