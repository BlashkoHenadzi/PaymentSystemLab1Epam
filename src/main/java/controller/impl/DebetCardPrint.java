package controller.impl;

import controller.Command;
import controller.CommandConsole;
import services.factory.ServiceFactory;

public class DebetCardPrint implements CommandConsole {
    @Override
    public String execute(String request) {
        return ServiceFactory.getInstance().getDebetCardService().ReadDebetCard().toString();
    }

    @Override
    public String[] getCommandParameters() {
        return new String[0];
    }
}
