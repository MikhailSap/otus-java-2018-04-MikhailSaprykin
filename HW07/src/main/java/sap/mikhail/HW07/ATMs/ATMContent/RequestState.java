package sap.mikhail.HW07.ATMs.ATMContent;


import sap.mikhail.HW07.ATMs.ATMContent.exceptions.AmountCannotBeIssuedException;
import sap.mikhail.HW07.ATMs.ATMContent.exceptions.NotHaveEnoughFundsExceprion;

public enum RequestState {
    DEPOSIT {
        public void doAction(Request request) {
            banknoteController.depositBanknotes(request.getRequestAMount());
            request.getClient().deposit(request.getRequestAMount());
            request.setRequestState(EXIT);
        }
    },
    ANALYSIS_FOR_WITHDRAW {
        public void doAction(Request request) {
            if (request.getClient().getBalance() >= request.getRequestAMount()) {
                request.setRequestState(ACCEPTED);
            } else {
                request.setRequestState(REJECTED);
            }
        }
    },
    ACCEPTED {
        public void doAction(Request request) {
            int withdraw = request.getRequestAMount();
            if (banknoteController.isPossibleIssuance(withdraw)) {
                banknoteController.withdrawalBanknotes();
                request.getClient().withdraw(withdraw);
                request.setRequestState(EXIT);
            } else {
                throw new AmountCannotBeIssuedException();
            }
        }
    },
    REJECTED {
        public void doAction(Request request) {
            throw new NotHaveEnoughFundsExceprion();
        }
    },
    EXIT {
        public void doAction(Request request) {}
    };

    BanknoteController banknoteController = new BanknoteController();
    public abstract void doAction(Request request);
}
