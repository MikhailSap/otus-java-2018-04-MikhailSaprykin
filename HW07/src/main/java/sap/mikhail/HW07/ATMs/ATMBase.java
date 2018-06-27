package sap.mikhail.HW07.ATMs;

import java.util.HashMap;

public class ATMBase {
    private static ATMBase atmBase = new ATMBase();
    private HashMap<Integer, ATM> atms = new HashMap<>();

    private ATMBase(){}

    public static ATMBase getAtmBase() {
        return atmBase;
    }

    public void addATM(ATM atm) {
        atms.put(atm.getID(), atm);
    }

    public ATM getATM(int id) {
        return atms.get(id);
    }

    public HashMap<Integer, ATM> getAllATM() {
        return atms;
    }
}
