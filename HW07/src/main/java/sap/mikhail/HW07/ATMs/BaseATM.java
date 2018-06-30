package sap.mikhail.HW07.ATMs;

import sap.mikhail.HW07.ATMs.ATMContent.*;

public abstract class BaseATM {
    protected final int ID;
    protected int countWithdrawRequests = 0;
    protected MoneyBank moneyBank = new MoneyBank();
    protected Request request;
    protected ClientsBase clientsBase = ClientsBase.getClientsBase();

    public BaseATM(int ID) {
        this.ID = ID;
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

    protected void setMoneySlots() {
        BanknoteController.setMoneySlots(moneyBank);
    }

    public int getCountWithdrawRequests() {
        return countWithdrawRequests;
    }

    public void setDefault() {
        countWithdrawRequests = 0;
        moneyBank.setDefault();
    }

    public int getBalance() {
        return moneyBank.getMoneyBankAmount();
    }

    public int getID() {
        return ID;
    }
}
