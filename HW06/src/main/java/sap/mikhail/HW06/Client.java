package sap.mikhail.HW06;

public class Client {
    private final int ID;
    private int balance;

    public Client(int id, int balance) {
        ID = id;
        this.balance = balance;
    }

    public int getId() {
        return ID;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int deposit) {
        this.balance = balance + deposit;
    }

    public void withdraw(int withdraw) {
        this.balance = balance - withdraw;
    }
}
