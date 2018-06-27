package sap.mikhail.HW07.ATMs;

public class ATMFactory {
    private int id=0;

    public ATM getATM(TypeATM type) {
        ATM atm = null;
        if (type == TypeATM.DEPOSIT_AND_WITHDRAW_ATM)
            atm = new DepositAndWithdrawATM(++id);
        if (type == TypeATM.WITHDRAW_ATM)
            atm = new WithdrawATM(++id);
        return atm;
    }

}
