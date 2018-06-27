package sap.mikhail.HW07.ATMs;

import sap.mikhail.HW07.ATMs.ATMContent.*;

import java.util.ArrayList;

public class DepositAndWithdrawATM implements ATM {
    private final int ID;
    private int countDepositRequests;
    private int countWithdrawRequests;
    private ArrayList<MoneySlot> moneySlots = MoneySlot.getMoneySlots();
    private Request request;
    private ClientsBase clientsBase = ClientsBase.getClientsBase();

    public DepositAndWithdrawATM(int id) {
        ID=id;
    }

    public void createDepositRequest(int clientId, int deposit) {
        countDepositRequests++;
        setMoneySlots();
        request = new DepositRequest(clientsBase.getClietn(clientId));
        request.setRequestAMount(deposit);
    }

    public void createWithdrawRequest(int clientId, int withdraw) {
        countWithdrawRequests++;
        setMoneySlots();
        request = new WithdrawRequest(clientsBase.getClietn(clientId));
        request.setRequestAMount(withdraw);
    }

    public int balanceRequest(int clientId) {
        return clientsBase.getClietn(clientId).getBalance();
    }

    public boolean clientExist(int clientId) {
        return clientsBase.getClietn(clientId) != null;
    }

    public void toHandleTheRequest() {
        boolean isExit = false;
        while (!isExit)
            isExit = request.toHandle();
    }

    private void setMoneySlots() {
        int i=0;
        for (MoneyBank banknote : MoneyBank.values()) {
            banknote.setMoneySlot(moneySlots.get(i++));
        }
    }

    public int getCountDepositRewuests() {
        return countDepositRequests;
    }

    public int getCountWithdrawRequests() {
        return countWithdrawRequests;
    }

    @Override
    public void setDefault() {
        setMoneySlots();
        countDepositRequests = 0;
        countWithdrawRequests = 0;
        for (MoneyBank banknote : MoneyBank.values()) {
            banknote.setCount(10);
        }

    }

    @Override
    public int getBalance() {
        setMoneySlots();
        return MoneyBank.getMoneyBankAmount();
    }

    @Override
    public int getID() {
        return ID;
    }
}
