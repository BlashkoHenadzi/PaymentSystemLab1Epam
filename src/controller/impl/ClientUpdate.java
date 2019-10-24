package controller.impl;

import beans.Client;
import controller.Command;
import services.factory.ServiceFactory;

public class ClientUpdate implements Command {
    @Override
    public String execute(String request) {
        String delimiter = ",";
        int id = Integer.parseInt(request.split(delimiter)[0]);
        String name = request.split(delimiter)[1];
        String surname = request.split(delimiter)[2];
        int clientcardcount = Integer.parseInt(request.split(delimiter)[3]);
        try {
            ServiceFactory.getInstance().getClientService().UpdateClient(new Client(name, surname, clientcardcount, id));
        }
        catch (Exception e){
            return "exception";
        }
        return "succesfull";
    }
}
