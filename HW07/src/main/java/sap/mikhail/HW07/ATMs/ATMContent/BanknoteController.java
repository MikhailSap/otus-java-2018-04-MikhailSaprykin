package sap.mikhail.HW07.ATMs.ATMContent;


import sap.mikhail.HW07.ATMs.ATMContent.exceptions.IncompatibleNominalException;

public class BanknoteController {

    public void depositBanknotes(int deposit) {
        boolean isCorrectNominal = false;
        for (MoneyBank banknote : MoneyBank.values())
            if (banknote.getNominal() == deposit) {
                banknote.setCount(banknote.getCount() + 1);
                isCorrectNominal = true;
            }
        if (!isCorrectNominal) {
            throw new IncompatibleNominalException();
        }
    }

    public boolean isPossibleIssuance(int withsrawAmount) {
        int checkWithdrawAmount = 0;
        int copyWithdrawAmount = withsrawAmount;
        int countBanknoteForWithdaw;
        for (MoneyBank banknote : MoneyBank.values()) {
            if (copyWithdrawAmount < banknote.getNominal())
                continue;
            countBanknoteForWithdaw = copyWithdrawAmount/banknote.getNominal();
            if (countBanknoteForWithdaw > banknote.getCount())
                continue;
            banknote.setCountForWithdraw(countBanknoteForWithdaw);
            copyWithdrawAmount = copyWithdrawAmount%banknote.getNominal();
        }
        for (MoneyBank banknote : MoneyBank.values())
            checkWithdrawAmount+=banknote.getCountForWithdraw()*banknote.getNominal();
        return checkWithdrawAmount == withsrawAmount;
    }

    public void withdrawalBanknotes() {
        for (MoneyBank banknote : MoneyBank.values())
            banknote.setCount(banknote.getCount()-banknote.getCountForWithdraw());
    }
}
