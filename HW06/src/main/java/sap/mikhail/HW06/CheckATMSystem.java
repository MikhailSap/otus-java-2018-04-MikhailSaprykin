package sap.mikhail.HW06;

public class CheckATMSystem {
    private static ClientsBase clientsBase = ClientsBase.getClientsBase();
    private static MoneyBank moneyBank = MoneyBank.getMoneyBank();

    public static void main(String[] args) {

        clientsBase.addClient(new Client(12345, 134500));
        clientsBase.addClient(new Client(54321, 5432));
        clientsBase.addClient(new Client(33333, 0));

        System.out.println("Client id-12345 before: " + ClientsBase.getClientsBase().getClietn(12345).getBalance());
        System.out.println("Amount money in ATM before: " + moneyBank.getAmount());
        System.out.println("Amount banknotes before: " + moneyBank.getBanknotes());

        new ATM();

        System.out.println("Client id-12345 after: " + ClientsBase.getClientsBase().getClietn(12345).getBalance());
        System.out.println("Amount money in ATM after: " + moneyBank.getAmount());
        System.out.println("Amount banknotes after: " + moneyBank.getBanknotes());


    }
}
