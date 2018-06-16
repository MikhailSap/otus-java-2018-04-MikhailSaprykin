package sap.mikhail.HW06;

public interface Request {
    Client getClient();

    void setRequestState(RequestState requestState);

    int getRequestAMount();

    void setRequestAMount(int requestMount);

    boolean toHandle();
}
