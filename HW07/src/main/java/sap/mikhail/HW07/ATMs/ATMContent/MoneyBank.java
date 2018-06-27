package sap.mikhail.HW07.ATMs.ATMContent;

public enum MoneyBank {
    FIVE_THOUSAND(5000),
    ONE_THOUSAND(1000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50);

    private int nominal;
    private MoneySlot moneySlot;

    public int getCountForWithdraw() {
        return moneySlot.getCountForWithdraw();
    }

    public void setCountForWithdraw(int countBanknoteForWithdraw) {
        moneySlot.setCountForWithdraw(countBanknoteForWithdraw);
    }

    public int getCount() {
        return moneySlot.getCount();
    }

    public void setCount(int count) {
        moneySlot.setCount(count);
    }

    public int getNominal() {
        return nominal;
    }

    public int getBanknoteAmount() {
        return nominal*getCount();
    }

    public static int getMoneyBankAmount() {
        int sum = 0;
        for (MoneyBank banknote : MoneyBank.values()) {
            sum += banknote.getBanknoteAmount();
        }
        return sum;
    }

    public void setMoneySlot(MoneySlot moneySlot) {
        this.moneySlot = moneySlot;
    }

    MoneyBank(int nominal) {
        this.nominal = nominal;
    }


}
