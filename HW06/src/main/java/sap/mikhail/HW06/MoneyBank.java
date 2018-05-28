package sap.mikhail.HW06;

import java.util.*;

public class MoneyBank {
    private static MoneyBank moneyBank = new MoneyBank();
    private int amount = 0;
    private int[] nominals = {5000, 1000, 500, 100, 50};
    private HashMap<Integer, Integer> banknotes = new HashMap<Integer, Integer>();

    private MoneyBank() {
        banknotes.put(5000, 5);
        banknotes.put(1000, 1);
        banknotes.put(500, 7);
        banknotes.put(100, 10);
        banknotes.put(50, 3);
        updateAmount();
    }

    public static MoneyBank getMoneyBank() {
        return moneyBank;
    }

    public HashMap<Integer, Integer> getBanknotes() {
        return banknotes;
    }

    public int getAmount() {
        return amount;
    }

    public void updateAmount() {
        int amount = 0;
        for (Map.Entry<Integer, Integer> pair : banknotes.entrySet()) {
            amount += (pair.getKey() * pair.getValue());
        }
        this.amount = amount;

    }

    public int depositBanknotes() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listNominals = Arrays.asList(5000, 1000, 500, 100, 50);
        String checkExit;
        int currentBanknote = 0;
        int currentAmount = 0;

        while (true) {
            checkExit = scanner.nextLine();
            if (checkExit.equals("ok")) {
                break;
            }

            try {
                currentBanknote = Integer.parseInt(checkExit);
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter number.");
                continue;
            }

            if (!listNominals.contains(currentBanknote)) {
                System.out.println("No correct nominal banknote." +
                        "\n" + "You must provide just 50, 100, 500, 1000, 5000 banknotes.");
                continue;
            }

            banknotes.put(currentBanknote, banknotes.get(currentBanknote)+1);
            currentAmount += currentBanknote;
            System.out.println("You have made " + currentAmount + " rubles.");
        }
        return currentAmount;
    }


    public boolean withdrawalBanknotes(int withsrawAmount) {
        HashMap<Integer, Integer> copyBanknotes = new HashMap<Integer, Integer>(banknotes);
        int checkAmount = withsrawAmount;
        int a = 1;

        for (int i = 0; i < nominals.length; i++) {
            if (withsrawAmount < nominals[i]) {
                continue;
            }
            while (true) {
                if (nominals[i]*a < checkAmount) {
                    a++;
                    continue;
                }

                if (nominals[i]*a > checkAmount) {

                    if ((a-1) >= copyBanknotes.get(nominals[i])) {
                        checkAmount -= nominals[i]*copyBanknotes.get(nominals[i]);
                        copyBanknotes.put(nominals[i], 0);
                        a = 1;
                        break;
                    } else {
                        checkAmount -= nominals[i]*(a-1);
                        copyBanknotes.put(nominals[i], copyBanknotes.get(nominals[i]) - (a-1));
                        a = 1;
                        break;
                    }

                } else {
                    copyBanknotes.put(nominals[i], copyBanknotes.get(nominals[i]) - a);
                    if (!checkBanknotes(copyBanknotes))
                        break;
                    banknotes = copyBanknotes;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkBanknotes(HashMap<Integer, Integer> banknotes) {

        for (Map.Entry<Integer, Integer> pair : banknotes.entrySet()) {
            if (pair.getValue() < 0)
                return false;
        }
        return true;
    }
}
