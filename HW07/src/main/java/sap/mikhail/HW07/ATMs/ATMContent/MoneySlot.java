package sap.mikhail.HW07.ATMs.ATMContent;

import java.util.ArrayList;

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


    public static ArrayList<MoneySlot> getMoneySlots() {
        ArrayList<MoneySlot> moneySlots = new ArrayList<>();
        for (int i=0; i<5; i++)
        moneySlots.add(new MoneySlot());
        return moneySlots;
    }

}
