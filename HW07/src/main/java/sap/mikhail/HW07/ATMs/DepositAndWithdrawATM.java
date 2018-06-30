package sap.mikhail.HW07.ATMs;

import sap.mikhail.HW07.ATMs.ATMContent.*;

public class DepositAndWithdrawATM extends BaseATM {
    private int countDepositRequests;

    public DepositAndWithdrawATM(int id) {
        super(id);
    }

    public void createDepositRequest(int clientId, int deposit) {
        countDepositRequests++;
        setMoneySlots();
        request = new DepositRequest(clientsBase.getClietn(clientId));
        request.setRequestAMount(deposit);
    }

    public int getCountDepositRequests() {
        return countDepositRequests;
    }

    @Override
    public void setDefault() {
        countDepositRequests = 0;
        countWithdrawRequests = 0;
        moneyBank.setDefault();
    }
}
