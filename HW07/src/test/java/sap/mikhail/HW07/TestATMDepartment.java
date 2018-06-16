package sap.mikhail.HW07;

import org.junit.Test;
import static org.junit.Assert.*;


import sap.mikhail.HW07.ATMDepartment.ATMBase;
import sap.mikhail.HW07.ATMDepartment.ATMDepartment;

public class TestATMDepartment {

    @Test
    public void setDefaultATMTest() {
        sap.mikhail.HW07.ATM00.ATM.getATM().startATM();

       try {
           Thread.sleep(500);
       }catch (Exception e) {}
       new ATMDepartment().setDefaultATM(000000);

       assertTrue(sap.mikhail.HW07.ATM00.ATM.getATM().isDefault());
    }

    @Test
    public void getBalanceATMTest() {
        sap.mikhail.HW07.ATM01.ATM.getATM().startATM();

        try {
            Thread.sleep(500);
        }catch (Exception e) {}
        new ATMDepartment().getBalanceATM(000001);

        assertTrue(ATMBase.getATMBase().getBase().get(0000001).getBalance() == 5000);
    }

    @Test
    public void setDefaultAllATMTest() {
        sap.mikhail.HW07.ATM00.ATM.getATM().startATM();
        sap.mikhail.HW07.ATM01.ATM.getATM().startATM();

        try {
            Thread.sleep(500);
        }catch (Exception e) {}
        new ATMDepartment().setDefaultAllATM();

        assertTrue(sap.mikhail.HW07.ATM00.ATM.getATM().isDefault());
        assertTrue(sap.mikhail.HW07.ATM01.ATM.getATM().isDefault());
    }

    @Test
    public void getBalancesFromAllATMTest() {
        sap.mikhail.HW07.ATM00.ATM.getATM().startATM();
        sap.mikhail.HW07.ATM01.ATM.getATM().startATM();

        try {
            Thread.sleep(500);
        }catch (Exception e) {}
        new ATMDepartment().getBalancesFromAllATM();

        assertTrue(ATMBase.getATMBase().getBase().get(0000000).getBalance() == 1000);
        assertTrue(ATMBase.getATMBase().getBase().get(0000001).getBalance() == 5000);
    }

    @Test
    public void getAllMoneyTest() {
        getBalancesFromAllATMTest();
        assertTrue(new ATMDepartment().getAllMoney() == 6000);
    }


}
