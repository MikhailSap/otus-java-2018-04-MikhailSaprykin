package sap.mikhail.HW06;


public class ATM {
    private Request request;
    private ClientsBase clientsBase = ClientsBase.getClientsBase();

    public void createDepositRequest(int clientId, int deposit) {
        request = new DepositRequest(clientsBase.getClietn(clientId));
        request.setRequestAMount(deposit);
    }

    public void createWithdrawRequest(int clientId, int withdraw) {
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
}
