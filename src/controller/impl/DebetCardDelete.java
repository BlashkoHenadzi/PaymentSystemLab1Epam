package controller.impl;

import controller.Command;
import services.factory.ServiceFactory;

public class DebetCardDelete implements Command {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request);
        try {
            ServiceFactory.getInstance().getDebetCardService().DeleteDebetCard(id);
        }
        catch(Exception e){
            return "Controller returns DeleteException" ;
        }
        return "Controller return Delete succesfull";
    }
}
