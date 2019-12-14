package controller.impl;
import beans.DebitCard;
import controller.CommandConsole;
import services.factory.ServiceFactory;

import java.time.LocalDate;

public class DebetCardUpdate implements CommandConsole {
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
            ServiceFactory.getInstance().getDebetCardService().UpdateDebetCard(new DebitCard(cardnumber,validthrue,balance,name,surname,accountnumber));
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
