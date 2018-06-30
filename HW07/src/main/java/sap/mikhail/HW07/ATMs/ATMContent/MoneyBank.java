package sap.mikhail.HW07.ATMs.ATMContent;


import java.util.HashMap;

public class MoneyBank {
    private  HashMap<Nominal, MoneySlot> moneySlots = MoneySlot.getMoneySlots();

    public HashMap<Nominal, MoneySlot> getMoneySlots() {
        return moneySlots;
    }

    private int getBanknoteAmount(Nominal banknote) {
        MoneySlot moneySlot = moneySlots.get(banknote);

        return banknote.getNominal()*moneySlot.getCount();
    }

    public int getMoneyBankAmount() {
        int sum = 0;
        for (Nominal banknote :Nominal.values()) {
            sum += getBanknoteAmount(banknote);
        }
        return sum;
    }

    public void setDefault() {
        moneySlots.forEach(
                (banknote, moneySlot) -> {moneySlot.setCount(10);}
        );
    }
}
