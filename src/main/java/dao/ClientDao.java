package dao;

import beans.Client;

import java.util.List;

public interface ClientDao {
    void AddClient(Client client);
    void DeleteClient(int id);
    void UpdateClient (Client client);
    void SortById();
    void SortByName();
    List<Client> ReadClient();
}
