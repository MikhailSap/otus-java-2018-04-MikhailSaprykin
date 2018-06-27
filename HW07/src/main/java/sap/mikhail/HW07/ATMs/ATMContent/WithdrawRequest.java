package sap.mikhail.HW07.ATMs.ATMContent;

public class WithdrawRequest implements Request {
    private Client client;
    private RequestState requestState;
    private int requestAMount;


    public WithdrawRequest(Client client) {
        this.client= client;
        requestState = RequestState.ANALYSIS_FOR_WITHDRAW;
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

    public boolean toHandle(){
        requestState.doAction(this);
        return requestState == RequestState.EXIT;
    }
}
