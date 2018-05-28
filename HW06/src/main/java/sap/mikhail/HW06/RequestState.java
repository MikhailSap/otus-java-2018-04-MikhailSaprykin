package sap.mikhail.HW06;


import java.util.Scanner;

public enum RequestState {
    DEPOSIT {
        int deposit;
        MoneyBank moneyBank = MoneyBank.getMoneyBank();

        public void doAction(Request request) {
            System.out.println("I accept just 50, 100, 500, 1000, 5000 banknotes." +
                    "\n" + "Please deposit cash. When you done, enter \"ok\".");
            deposit = moneyBank.depositBanknotes();
            request.getClient().depositBalance(deposit);
            System.out.println(deposit + " rubles will be credited to your account");
            moneyBank.updateAmount();
            System.out.println("Goodbye.");
            request.setRequestState(EXIT);
        }
    },
    ANALYSISFORWITHSRAW {
        int withdraw;
        Client client;
        Scanner scanner = new Scanner(System.in);

        public void doAction(Request request) {
            System.out.println("How match money you need?");
            while (true) {
                withdraw = scanner.nextInt();
                if(withdraw%50 != 0) {
                    System.out.println("Please enter requested amount correct");
                } else { break; }
            }
            client = request.getClient();
            if (client.getBalance() >= withdraw) {
                request.setRequestMount(withdraw);
                request.setRequestState(ACCEPTED);
            } else {
                request.setRequestState(REJECTED);
            }
        }
    },
    ACCEPTED {
        int withdraw;
        MoneyBank moneyBank = MoneyBank.getMoneyBank();

        public void doAction(Request request) {
            withdraw = request.getRequestMount();
            if (moneyBank.withdrawalBanknotes(withdraw)) {
                request.getClient().withdrawBalance(withdraw);
                System.out.println("Please take you money." + "\n" + "Goodbye.");
                moneyBank.updateAmount();
                request.setRequestState(EXIT);
            } else {
                System.out.println("The requested amount cannot be issued, please enter another amount.");
                request.setRequestState(ANALYSISFORWITHSRAW);
            }
        }
    },
    REJECTED {
        public void doAction(Request request) {
            System.out.println("Your account does not have enough funds, please enter another amount.");
            request.setRequestState(ANALYSISFORWITHSRAW);
        }
    },
    EXIT {
        public void doAction(Request request) throws Exception {
        throw new Exception();
        }
    };
    public abstract void doAction(Request request) throws Exception;
}
