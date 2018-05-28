package sap.mikhail.HW06;

public class DepositRequest implements Request {
    private Client client;
    private RequestState requestState;
    private int requestMount;

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

    public int getRequestMount() {
        return requestMount;
    }

    public void setRequestMount(int requestMount) {
        this.requestMount = requestMount;
    }

    public void doAction() throws Exception{
            requestState.doAction(this);
    }
}
