package sap.mikhail.HW07.ATMs.ATMContent;


import sap.mikhail.HW07.ATMs.ATMContent.exceptions.IncompatibleNominalException;

import java.util.HashMap;

public class BanknoteController {
    private static HashMap<Nominal, MoneySlot> moneySlots;
    private MoneySlot moneySlot = null;

    public static void setMoneySlots(MoneyBank moneyBank) {
        moneySlots = moneyBank.getMoneySlots();
    }

    public void depositBanknotes(int deposit) {
        boolean isCorrectNominal = false;
        for (Nominal banknote : Nominal.values())
            if (banknote.getNominal() == deposit) {
                moneySlot = moneySlots.get(banknote);
                moneySlot.setCount(moneySlot.getCount() + 1);
                isCorrectNominal = true;
            }
        if (!isCorrectNominal) {
            throw new IncompatibleNominalException();
        }
    }

    public boolean isPossibleIssuance(int withdrawAmount) {
        int copyWithdrawAmount = withdrawAmount;
        int countBanknoteForWithdraw;
        for (Nominal banknote : Nominal.values()) {
            moneySlot = moneySlots.get(banknote);
            if (copyWithdrawAmount < banknote.getNominal())
                continue;
            countBanknoteForWithdraw = copyWithdrawAmount/banknote.getNominal();
            if (countBanknoteForWithdraw > moneySlot.getCount())
                continue;
            moneySlot.setCountForWithdraw(countBanknoteForWithdraw);
            copyWithdrawAmount = copyWithdrawAmount%banknote.getNominal();
        }
        return copyWithdrawAmount == 0;
    }

    public void withdrawalBanknotes() {
        for (Nominal banknote : Nominal.values()) {
            moneySlot = moneySlots.get(banknote);
            moneySlot.setCount(moneySlot.getCount() - moneySlot.getCountForWithdraw());
        }
    }
}
