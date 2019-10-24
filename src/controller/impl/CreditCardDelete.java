package controller.impl;

import controller.Command;
import services.factory.ServiceFactory;

public class CreditCardDelete implements Command {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request);
        try {
            ServiceFactory.getInstance().getCcreditCardService().DeleteCreditCard(id);
        }
        catch(Exception e){
            return "Controller returns DeleteException" ;
        }
        return "Controller return Delete succesfull";
    }
}
