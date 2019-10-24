package controller.impl;

import controller.CommandConsole;
import services.factory.ServiceFactory;

import java.io.Serializable;

public class SearchCreditCardByName implements CommandConsole {
    @Override
    public String[] getCommandParameters() {
        return new String[]{"name"};
    }

    @Override
    public String execute(String request) {
        return ServiceFactory.getInstance().getCcreditCardService().SearchByName(request.split(",")[0]).toString();
    }
}
