package controller.impl;

import controller.CommandConsole;
import services.factory.ServiceFactory;

public class ClientSortByName implements CommandConsole {
    @Override
    public String[] getCommandParameters() {
        return new String[0];
    }

    @Override
    public String execute(String request) {
        try{
            ServiceFactory.getInstance().getClientService().SortByName();}
        catch (Exception e){
            return "Failed";
        }
        return "Succesfull";
    }
}
