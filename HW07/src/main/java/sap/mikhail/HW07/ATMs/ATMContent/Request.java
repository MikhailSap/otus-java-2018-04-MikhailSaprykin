package sap.mikhail.HW07.ATMs.ATMContent;

public interface Request {
    Client getClient();

    void setRequestState(RequestState requestState);

    int getRequestAMount();

    void setRequestAMount(int requestMount);

    boolean toHandle();
}
