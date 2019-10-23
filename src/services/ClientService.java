package services;

import beans.Client;

public interface ClientService {
    void AddClient(Client client);
    void DeleteClient(Client client);
    void UpdateClient (Client client);
}
