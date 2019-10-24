package controller.impl;

import controller.Command;
import controller.CommandConsole;
import services.factory.ServiceFactory;

public class CreditCardPrint implements CommandConsole {
    @Override
    public String execute(String request) {
        return ServiceFactory.getInstance().getCcreditCardService().ReadCreditCard().toString();
    }

    @Override
    public String[] getCommandParameters() {
        return new String[0];
    }
}
