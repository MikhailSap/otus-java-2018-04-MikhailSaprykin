package sap.mikhail.HW06;

public interface Request {
    Client getClient();

    void setRequestState(RequestState requestState);

    int getRequestMount();

    void setRequestMount(int requestMount);

    void doAction() throws Exception;
}
