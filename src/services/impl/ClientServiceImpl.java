package services.impl;

import beans.Client;
import dao.ClientDao;
import dao.factory.DaoFactory;
import services.ClientService;

public class ClientServiceImpl implements ClientService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    ClientDao clientDao = daoFactory.getClientDAO();
    @Override
    public void AddClient(Client client) {
        if ((client.getName().length()>1) && (client.getSurname().length()>1))
            clientDao.AddClient(client);

    }

    @Override
    public void DeleteClient(Client client) {
        if (client!=null)
            clientDao.DeleteClient(client);

    }

    @Override
    public void UpdateClient(Client client) {
        if (client!=null)
            clientDao.UpdateClient(client);

    }
}
