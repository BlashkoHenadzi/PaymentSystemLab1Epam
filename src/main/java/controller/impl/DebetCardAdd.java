package controller.impl;


import beans.DebitCard;
import controller.CommandConsole;
import services.factory.ServiceFactory;

import java.time.LocalDate;

public class DebetCardAdd implements CommandConsole {
    @Override
    public String execute(String request) {
        String delimiter = ",";
        int cardnumber =Integer.parseInt(request.split(delimiter)[0]);
        LocalDate validthrue = LocalDate.parse(request.split(delimiter)[1]);
        int balance = Integer.parseInt(request.split(delimiter)[2]);
        String name = request.split(delimiter)[3];
        String surname = request.split(delimiter)[4];
        int accountnumber = Integer.parseInt(request.split(delimiter)[5]);

        try {

            ServiceFactory.getInstance().getDebetCardService().AddDebetCard (new DebitCard(cardnumber,validthrue,balance,name,surname,accountnumber));
        }
        catch (Exception e){
            return "Controller return AddException";
        }
        return "Controller return Succesfull";
    }

    @Override
    public String[] getCommandParameters() {
        return new String[]{"card-number","valid-thru","balance","card-holder-name","card-holder-surname","account-number"};
    }
}
