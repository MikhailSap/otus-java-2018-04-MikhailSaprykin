package sap.mikhail.HW06;

public class Client {
    private int id;
    private int balance;

    public Client(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void depositBalance(int deposit) {
        this.balance = balance + deposit;
    }

    public void withdrawBalance(int withdraw) {
        this.balance = balance - withdraw;
    }
}
