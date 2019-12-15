package services.impl;

import beans.User;
import dao.ClientDao;
import dao.factory.DaoFactory;
import services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    ClientDao clientDao = daoFactory.getClientDAO();


    @Override
    public void AddClient(User user) {
        if ((user.getName().length()>1) && (user.getSurname().length()>1))
            clientDao.AddClient(user);



    }

    @Override
    public void DeleteClient(int id) {
            clientDao.DeleteClient(id);

    }

    @Override
    public void UpdateClient(User user) {
        if (user !=null)
            clientDao.UpdateClient(user);

    }

    @Override
    public List<User> ReadClient() {
        return clientDao.ReadClient();
    }

    @Override
    public int GetMaxId() {
        int maxid = 0;
        for (User user : clientDao.ReadClient()) {
            maxid = user.getId()>maxid? user.getId():maxid;
        }
        return maxid;
    }

    @Override
    public void SortById() {
        clientDao.SortById();
    }

    @Override
    public void SortByName() {
        clientDao.SortByName();
    }

}
