package services.impl;

import beans.Client;
import dao.ClientDao;
import dao.factory.DaoFactory;
import services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    ClientDao clientDao = daoFactory.getClientDAO();


    @Override
    public void AddClient(Client client) {
        if ((client.getName().length()>1) && (client.getSurname().length()>1))
            clientDao.AddClient(client);

    }

    @Override
    public void DeleteClient(int id) {
            clientDao.DeleteClient(id);

    }

    @Override
    public void UpdateClient(Client client) {
        if (client!=null)
            clientDao.UpdateClient(client);

    }

    @Override
    public List<Client> ReadClient() {
        return clientDao.ReadClient();
    }

    @Override
    public int GetMaxId() {
        int maxid = 0;
        for (Client client: clientDao.ReadClient()) {
            maxid = client.getId()>maxid?client.getId():maxid;
        }
        return maxid;
    }
}
