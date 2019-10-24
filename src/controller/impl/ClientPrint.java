package controller.impl;

import beans.Client;
import controller.Command;
import controller.CommandConsole;
import services.factory.ServiceFactory;

public class ClientPrint implements CommandConsole {
    @Override
    public String execute(String request) {
        return  ServiceFactory.getInstance().getClientService().ReadClient().toString();

}

    @Override
    public String[] getCommandParameters() {
        return new String[0];
    }
}
