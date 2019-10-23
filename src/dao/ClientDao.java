package dao;

import beans.Client;

import java.util.List;

public interface ClientDao {
    void AddClient(Client client);
    void DeleteClient(Client client);
    void UpdateClient (Client client);
    List<Client> ReadClient();
}
