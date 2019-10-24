package controller.impl;

import controller.Command;
import services.factory.ServiceFactory;

public class CreditCardPrint implements Command {
    @Override
    public String execute(String request) {
        return ServiceFactory.getInstance().getCcreditCardService().ReadCreditCard().toString();
    }
}
