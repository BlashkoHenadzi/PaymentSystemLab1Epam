package services;

import beans.Client;

import java.util.List;

public interface ClientService {
    void AddClient(Client client);
    void DeleteClient(int id);
    void UpdateClient (Client client);
    List<Client> ReadClient();
    int GetMaxId();
    void SortById();
    void SortByName();
}
