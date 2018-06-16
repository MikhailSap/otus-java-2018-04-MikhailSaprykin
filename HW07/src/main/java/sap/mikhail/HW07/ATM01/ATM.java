package sap.mikhail.HW07.ATM01;

public class ATM {
    private static ATM atm = new ATM();
    private int id = 0000001;
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
        return 5000;
    }

    public String setDefault() {
        isDefault = true;
        return "ATM ID 0000001 brought to the default state.(side ATMDepartment)";
    }

}
