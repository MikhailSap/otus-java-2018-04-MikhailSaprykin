package sap.mikhail.HW07.ATMDepartment;

public class ATM {
    private int id;
    private String ip;
    private int port;
    private int balance;

    public ATM(int id, String ip, int port, int balance) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
