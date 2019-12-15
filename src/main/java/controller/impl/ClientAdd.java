package controller.impl;

import beans.User;
import controller.CommandConsole;
import services.factory.ServiceFactory;

public class ClientAdd implements CommandConsole {
    @Override
    public String execute(String request) {
        String delimiter = ",";
        String name = request.split(delimiter)[0];
        String surname = request.split(delimiter)[1];
        int clientcardcount = Integer.parseInt(request.split(delimiter)[2]);

        try {
            int id = ServiceFactory.getInstance().getClientService().GetMaxId()+1;
            ServiceFactory.getInstance().getClientService().AddClient(new User(name,surname,clientcardcount,id));
        }
        catch (Exception e){
            return "Controller return AddException";
        }
        return "Controller return Succesfull";

    }

    @Override
    public String[] getCommandParameters() {
        return new String[]{"name","surname","client-cards-count"};
    }
}
