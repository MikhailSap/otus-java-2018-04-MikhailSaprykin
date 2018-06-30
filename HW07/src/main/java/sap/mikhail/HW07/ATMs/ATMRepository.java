package sap.mikhail.HW07.ATMs;

import java.util.HashMap;

public class ATMRepository {
    private static ATMRepository atmRepository = new ATMRepository();
    private HashMap<Integer, BaseATM> atms = new HashMap<>();

    private ATMRepository(){}

    public static ATMRepository getAtmRepository() {
        return atmRepository;
    }

    public void addATM(BaseATM atm) {
        atms.put(atm.getID(), atm);
    }

    public BaseATM getATM(int id) {
        return atms.get(id);
    }

    public HashMap<Integer, BaseATM> getAllATM() {
        return atms;
    }
}
