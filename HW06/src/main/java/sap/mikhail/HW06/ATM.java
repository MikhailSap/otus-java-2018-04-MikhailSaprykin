package sap.mikhail.HW06;

import java.util.Scanner;

public class ATM {

    private int clientId;
    private int clientChoice = 0;
    private Request request;
    private ClientsBase  clientsBase = ClientsBase.getClientsBase();
    private Scanner scanner = new Scanner(System.in);

    public ATM() {
        creatRequest();
    }

    private void creatRequest() {
        System.out.println("Welcome to Saprykin's banking system." +
                "\n" + "Please enter you id five nubmers.");

        while(true) {
            try {
                clientId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter number.");
                continue;
            }
            if (!checkClientId(clientId)) {
                System.out.println("No such client, please try again.");
                continue;
            }
            break;
        }

        System.out.println("select the operation:" +
                "\n" + "1---Deposit" +
                "\n" + "2---Withdraw" +
                "\n" + "3---For exit");

        while(true) {
            try {
                clientChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter number.");
                continue;
            }
            if (clientChoice < 1 || clientChoice > 3) {
                System.out.println("No such operation, please try again.");
                continue;
            }
            break;
        }

        if (clientChoice == 1) {
            request = new DepositRequest(clientsBase.getClietn(clientId));
            toHandleTheRequest();
        }

        if (clientChoice == 2) {
            request = new WithdrawRequest(clientsBase.getClietn(clientId));
            toHandleTheRequest();
        }

    }

    private void toHandleTheRequest() {
        while (true)
        try {
            request.doAction();
        } catch (Exception e) {
            break;
        }
    }

    private boolean checkClientId(int clientId) {
        return clientsBase.getClietn(clientId) != null;
    }
}
