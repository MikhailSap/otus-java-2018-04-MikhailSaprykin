package sap.mikhail.HW06;

public enum MoneyBank {
    FIVE_THOUSAND(5000, 0),
    ONE_THOUSAND(1000, 0),
    FIVE_HUNDRED(500, 0),
    ONE_HUNDRED(100, 0),
    FIFTY(50, 0);

    private int nominal;
    private int count;
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

    public int getNominal() {
        return nominal;
    }

    public int getBanknoteAmount() {
        return nominal*count;
    }

    public static int getMoneyBankAmount() {
        int sum = 0;
        for (MoneyBank banknote : MoneyBank.values()) {
            sum += banknote.getBanknoteAmount();
        }
        return sum;
    }

    MoneyBank(int nominal, int count) {
        this.nominal = nominal;
        this.count = count;
    }


}
