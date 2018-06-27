package sap.mikhail.HW07.ATMs.ATMContent;

public class DepositRequest implements Request {
    private Client client;
    private RequestState requestState;
    private int requestAMount;

    public DepositRequest(Client client) {
        this.client = client;
        requestState = RequestState.DEPOSIT;

    }

    public Client getClient() {
        return client;
    }

    public void setRequestState(RequestState requestState) {
        this.requestState = requestState;
    }

    public int getRequestAMount() {
        return requestAMount;
    }

    public void setRequestAMount(int requestMount) {
        this.requestAMount = requestMount;
    }


    public boolean toHandle() {
        requestState.doAction(this);
        return requestState == RequestState.EXIT;
    }
}
