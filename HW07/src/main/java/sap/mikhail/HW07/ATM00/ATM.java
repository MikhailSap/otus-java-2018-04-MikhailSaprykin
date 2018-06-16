package sap.mikhail.HW07.ATM00;

public class ATM {
    private static ATM atm = new ATM();
    private int id = 0000000;
    private boolean isDefault;

    private ATM() {

    }

    public void startATM() {
        Thread server = new Thread(new ATMServer());
        server.start();

        //working

    }

    public boolean isDefault() {
        return isDefault;
    }

    public int getId() {
        return id;
    }

    public static ATM getATM() {
        return atm;
    }

    public int getBalance() {
        return 1000;
    }

    public String setDefault() {
        isDefault = true;
        return "ATM ID 0000000 brought to the default state.(side ATMDepartment)";
    }

}
