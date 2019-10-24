package controller.impl;

import beans.Client;
import beans.CreditCard;
import controller.Command;
import controller.CommandConsole;
import services.factory.ServiceFactory;

import java.time.LocalDate;

public class CreditCardUpdate implements CommandConsole {
    @Override
    public String execute(String request) {
        String delimiter = ",";
        int cardnumber =Integer.parseInt(request.split(delimiter)[0]);
        LocalDate validthrue = LocalDate.parse(request.split(delimiter)[1]);
        int balance = Integer.parseInt(request.split(delimiter)[2]);
        String name = request.split(delimiter)[3];
        String surname = request.split(delimiter)[4];
        int creditbalance = Integer.parseInt(request.split(delimiter)[5]);
        try {
            ServiceFactory.getInstance().getCcreditCardService().UpdateCreditCard(new CreditCard(cardnumber,validthrue,balance,name,surname,creditbalance));
        }
        catch (Exception e){
            return "exception";
        }
        return "succesfull";
    }

    @Override
    public String[] getCommandParameters() {
        return new String[]{"cardnumber","valid thrue YYYY-MM-DD","balance","name","surname","creditbalance"};
    }
}
