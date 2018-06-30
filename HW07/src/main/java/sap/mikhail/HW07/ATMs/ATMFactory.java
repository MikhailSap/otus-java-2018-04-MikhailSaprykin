package sap.mikhail.HW07.ATMs;

public class ATMFactory {
    private int id=0;

    public BaseATM getATM(TypeATM type) {
        BaseATM atm = null;
        if (type == TypeATM.DEPOSIT_AND_WITHDRAW_ATM)
            atm = new DepositAndWithdrawATM(++id);
        if (type == TypeATM.WITHDRAW_ATM)
            atm = new WithdrawATM(++id);
        return atm;
    }

}
