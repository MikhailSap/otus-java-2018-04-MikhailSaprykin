package sap.mikhail.HW07;

import org.junit.Test;
import sap.mikhail.HW07.ATMDepartment.ATMDepartment;
import sap.mikhail.HW07.ATMs.*;
import sap.mikhail.HW07.ATMs.ATMContent.ClientsBase;

import java.util.HashMap;

import static org.junit.Assert.*;


public class TestATMDepartment {
    ATMDepartment atmDepartment = new ATMDepartment();
    ATMFactory atmFactory = new ATMFactory();
    ATMRepository atmRepository = ATMRepository.getAtmRepository();
    ClientsBase clientsBase = ClientsBase.getClientsBase();
    DepositAndWithdrawATM depositAndWithdrawATM;
    WithdrawATM withdrawATM;

    @Test
    public void atmFactoryTest() {
       BaseATM atm1 = atmFactory.getATM(TypeATM.DEPOSIT_AND_WITHDRAW_ATM); //creat ATM with ID=1
       BaseATM atm2 = atmFactory.getATM(TypeATM.WITHDRAW_ATM); //creat ATM with ID=2

        assertTrue(atm1 instanceof DepositAndWithdrawATM);
        assertTrue(atm2 instanceof WithdrawATM);
    }

    public void init() {
        atmRepository.addATM(atmFactory.getATM(TypeATM.DEPOSIT_AND_WITHDRAW_ATM)); //creat ATM with ID=1
        atmRepository.addATM(atmFactory.getATM(TypeATM.WITHDRAW_ATM)); //creat ATM with ID=2

        depositAndWithdrawATM = (DepositAndWithdrawATM) atmRepository.getATM(1);
        withdrawATM = (WithdrawATM) atmRepository.getATM(2);

        clientsBase.addClient(1, 125000);
    }

    @Test
    public void getBalanceFromATMTest() {
        init();
        //default balance ATM is - 66500

        depositAndWithdrawATM.createDepositRequest(1, 5000);
        depositAndWithdrawATM.toHandleTheRequest();
        depositAndWithdrawATM.createDepositRequest(1, 1000);
        depositAndWithdrawATM.toHandleTheRequest();
        depositAndWithdrawATM.createWithdrawRequest(1, 500);
        depositAndWithdrawATM.toHandleTheRequest();

        int balance = atmDepartment.getBalanceATM(1);
        assertTrue(balance == 72000);
    }

    @Test
    public void setDefaultATMTest() {
        init();

        int balance;
        int countWithdrawRequests;
        balance = atmDepartment.getBalanceATM(2);
        countWithdrawRequests = withdrawATM.getCountWithdrawRequests();

        assertTrue(balance == 66500);
        assertTrue(countWithdrawRequests == 0);

        withdrawATM.createWithdrawRequest(1, 5000);
        withdrawATM.toHandleTheRequest();
        withdrawATM.createWithdrawRequest(1, 5000);
        withdrawATM.toHandleTheRequest();
        withdrawATM.createWithdrawRequest(1, 5000);
        withdrawATM.toHandleTheRequest();

        balance = atmDepartment.getBalanceATM(2);
        countWithdrawRequests = withdrawATM.getCountWithdrawRequests();

        assertTrue(balance == 51500);
        assertTrue(countWithdrawRequests == 3);

        atmDepartment.setDefaultATM(2);

        balance = atmDepartment.getBalanceATM(2);
        countWithdrawRequests = withdrawATM.getCountWithdrawRequests();

        assertTrue(balance == 66500);
        assertTrue(countWithdrawRequests == 0);
    }


    @Test
    public void setDefaultAllATMTest() {
        init();

        depositAndWithdrawATM.createDepositRequest(1, 5000);
        depositAndWithdrawATM.toHandleTheRequest();
        depositAndWithdrawATM.createDepositRequest(1, 1000);
        depositAndWithdrawATM.toHandleTheRequest();
        depositAndWithdrawATM.createWithdrawRequest(1, 500);
        depositAndWithdrawATM.toHandleTheRequest();


        withdrawATM.createWithdrawRequest(1, 5000);
        withdrawATM.toHandleTheRequest();
        withdrawATM.createWithdrawRequest(1, 5000);
        withdrawATM.toHandleTheRequest();
        withdrawATM.createWithdrawRequest(1, 5000);
        withdrawATM.toHandleTheRequest();

        atmDepartment.setDefaultAllATM();

        assertTrue(depositAndWithdrawATM.getBalance() == 66500);
        assertTrue(withdrawATM.getBalance() == 66500);
        assertTrue(depositAndWithdrawATM.getCountDepositRequests() == 0);
        assertTrue(depositAndWithdrawATM.getCountWithdrawRequests() == 0);
        assertTrue(withdrawATM.getCountWithdrawRequests() == 0);
    }

    @Test
    public void getBalancesFromAllATMTest() {
        init();

        HashMap<Integer, Integer> balances = atmDepartment.getBalancesFromAllATM();

        balances.forEach(
                (id, balance) -> {
                    assertTrue(balance == 66500);
                }
        );

    }

    @Test
    public void getAllMoneyTest() {
        init();

        assertTrue(atmDepartment.getAllMoney() == 133000);
    }


}
