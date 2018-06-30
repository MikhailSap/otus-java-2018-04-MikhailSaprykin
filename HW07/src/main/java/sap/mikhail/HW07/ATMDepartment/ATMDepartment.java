package sap.mikhail.HW07.ATMDepartment;



import sap.mikhail.HW07.ATMs.ATMRepository;
import sap.mikhail.HW07.ATMs.BaseATM;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class ATMDepartment {
    private ATMRepository atmRepository = ATMRepository.getAtmRepository();

    public HashMap<Integer, Integer> getBalancesFromAllATM() {
       int id;
       int balance;
       HashMap<Integer, Integer> balansesFromAllATM = new HashMap<>();
       for (Map.Entry<Integer, BaseATM> atm : atmRepository.getAllATM().entrySet()) {
           id = atm.getKey();
           balance = atm.getValue().getBalance();
           balansesFromAllATM.put(id, balance);
       }
        return balansesFromAllATM;
    }

    public void setDefaultAllATM() {
        atmRepository.getAllATM().forEach(
                (id, atm) -> {
                    atm.setDefault();
                }
        );

    }

    public int getBalanceATM(int id) {
        return atmRepository.getATM(id).getBalance();
    }


    public void setDefaultATM(int id) {
        atmRepository.getATM(id).setDefault();
    }

    public int getAllMoney() {
        int allMoney = 0;
        Collection balences = getBalancesFromAllATM().values();
        for (Object balance : balences) {
            allMoney += (int)balance;
        }
        return allMoney;
    }
}

