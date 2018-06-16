package sap.mikhail.HW06;

import org.junit.Test;
import sap.mikhail.HW06.exceptions.AmountCannotBeIssuedException;
import sap.mikhail.HW06.exceptions.IncompatibleNominalException;
import sap.mikhail.HW06.exceptions.NotHaveEnoughFundsExceprion;

import static org.junit.Assert.*;
public class ATMTest {

    public void fillMoneyBank() { // Add to money bank 6650 rub. or one banknote of each nominal..
        for (MoneyBank banknote : MoneyBank.values()) {
            banknote.setCount(1);
        }
    }

    public void resetMoneyBank() {
        for (MoneyBank banknote : MoneyBank.values()) {
            banknote.setCount(0);
        }
    }

    @Test
    public void depositRequestTest() {
        ATM atm = new ATM();

        atm.createDepositRequest(33333, 5000);
        atm.toHandleTheRequest();
        atm.createDepositRequest(33333, 1000);
        atm.toHandleTheRequest();
        atm.createDepositRequest(33333, 500);
        atm.toHandleTheRequest();
        atm.createDepositRequest(33333, 100);
        atm.toHandleTheRequest();
        atm.createDepositRequest(33333, 50);
        atm.toHandleTheRequest();

        boolean checkBanknoteCount = true;
        for (MoneyBank banknote : MoneyBank.values()) {
            if (banknote.getCount() != 1)
                checkBanknoteCount = false;
        }

        assertTrue(checkBanknoteCount);
        resetMoneyBank();
    }

    @Test
    public void withdrawRequestTest_Successful() {
        ATM atm = new ATM();
        fillMoneyBank();

        atm.createWithdrawRequest(12345, 6650);
        atm.toHandleTheRequest();

        boolean checkBanknotes = true;
        for(MoneyBank banknote : MoneyBank.values()) {
            if (banknote.getCount() != 0)
                checkBanknotes = false;
        }
        assertTrue(checkBanknotes);

        int checkBalance = ClientsBase.getClientsBase().getClietn(12345).getBalance();
        assertTrue(checkBalance == 0);
    }

    @Test
    public void withdrawRequestTest_ImpossibleBanknoteCombination() {
        ATM atm = new ATM();
        fillMoneyBank();
        atm.createWithdrawRequest(12345, 4500);
        boolean checkBanknoteCombination = false;


        try {
            atm.toHandleTheRequest();
        } catch (AmountCannotBeIssuedException aie) {
            checkBanknoteCombination = true;
        }

        assertTrue(checkBanknoteCombination);
        resetMoneyBank();
    }

    @Test
    public void withdrawRequestTest_NotEnoughMoneyInMoneyBank() {
        ATM atm = new ATM();
        fillMoneyBank();
        atm.createWithdrawRequest(00000, 7000);
        boolean checkEnoughMoneyInMoneyInMoneyBank = false;


        try {
            atm.toHandleTheRequest();
        } catch (AmountCannotBeIssuedException aie) {
            checkEnoughMoneyInMoneyInMoneyBank = true;
        }

        assertTrue(checkEnoughMoneyInMoneyInMoneyBank);
        resetMoneyBank();
    }

    @Test
    public void withdrawRequestTest_NotEnoughMoneyOnClientAccount() {
        ATM atm = new ATM();
        fillMoneyBank();
        atm.createWithdrawRequest(54321, 7000); // On Cient Account 5432 rub..
        boolean checkEnoughMoneyOnClientAccount = false;


        try {
            atm.toHandleTheRequest();
        } catch (NotHaveEnoughFundsExceprion nhfe) {
            checkEnoughMoneyOnClientAccount = true;
        }

        assertTrue(checkEnoughMoneyOnClientAccount);
        resetMoneyBank();
    }

    @Test
    public void balanceRequestTest() {
        ATM atm = new ATM();

        int checkBalance = atm.balanceRequest(54321);

        assertTrue(checkBalance == 5432);
    }
}
