package sap.mikhail.HW07.ATMDepartment;

import java.util.HashMap;

public class ATMBase {
    private static ATMBase atmBase = new ATMBase();
    private HashMap<Integer, ATM> base = new HashMap<Integer, ATM>();

    private ATMBase(){
        base.put(0000000, new ATM(0000000, "127.0.0.1", 1099, 0));
        base.put(0000001, new ATM(0000001, "127.0.0.1", 1199, 0));
    }

    public static ATMBase getATMBase() {
        return atmBase;
    }

    public HashMap<Integer, ATM> getBase() {
        return base;
    }
}
