package controller.impl;

import beans.Client;
import controller.Command;
import dao.ClientDao;
import services.factory.ServiceFactory;

public class ClientAdd implements Command {
    @Override
    public String execute(String request) {
        String delimiter = ",";
        String name = request.split(delimiter)[0];
        String surname = request.split(delimiter)[1];
        int clientcardcount = Integer.parseInt(request.split(delimiter)[2]);

        try {
            int id = ServiceFactory.getInstance().getClientService().GetMaxId();
            ServiceFactory.getInstance().getClientService().AddClient(new Client(name,surname,clientcardcount,id));
        }
        catch (Exception e){
            return "Controller return AddException";
        }
        return "Controller return Succesfull";

    }
}
