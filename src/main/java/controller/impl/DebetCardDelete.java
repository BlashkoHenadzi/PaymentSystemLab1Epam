package controller.impl;

import controller.Command;
import controller.CommandConsole;
import services.factory.ServiceFactory;

public class DebetCardDelete implements CommandConsole {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request.split(",")[0]);
        try {
            ServiceFactory.getInstance().getDebetCardService().DeleteDebetCard(id);
        }
        catch(Exception e){
            return "Controller returns DeleteException" ;
        }
        return "Controller return Delete succesfull";
    }

    @Override
    public String[] getCommandParameters() {
        return new String[]{"id"};
    }
}
