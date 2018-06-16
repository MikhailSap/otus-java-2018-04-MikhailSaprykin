package sap.mikhail.HW07.ATMDepartment;

public class TestATMDepartment {
    public static void main(String[] args) {
        ATMDepartment department = new ATMDepartment();

        department.setDefaultAllATM();
        department.setDefaultATM(0000001);
        department.getBalanceATM(0000000);
        System.out.println("Balance ATM ID 0000000 is: " + ATMBase.getATMBase().getBase().get(0000000).getBalance());
    }
}
