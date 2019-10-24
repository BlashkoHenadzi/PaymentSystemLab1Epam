package controller.impl;

import beans.Client;
import controller.Command;
import services.factory.ServiceFactory;

public class ClientPrint implements Command {
    @Override
    public String execute(String request) {
        return  ServiceFactory.getInstance().getClientService().ReadClient().toString();

}
}
