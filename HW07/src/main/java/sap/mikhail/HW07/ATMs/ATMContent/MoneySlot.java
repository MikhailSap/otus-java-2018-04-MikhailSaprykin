package sap.mikhail.HW07.ATMs.ATMContent;

import java.util.ArrayList;
import java.util.HashMap;

public class MoneySlot {
    private int count = 10;
    private int countForWithdraw;

    public int getCountForWithdraw() {
        return countForWithdraw;
    }

    public void setCountForWithdraw(int countBanknoteForWithdraw) {
        this.countForWithdraw = countBanknoteForWithdraw;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public static HashMap<Nominal, MoneySlot> getMoneySlots() {
        HashMap<Nominal, MoneySlot> moneySlots = new HashMap<>();
        for (Nominal banknote : Nominal.values())
            moneySlots.put(banknote, new MoneySlot());
        return moneySlots;
    }

}
