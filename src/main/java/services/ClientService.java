package services;

import beans.User;

import java.util.List;

public interface ClientService {
    void AddClient(User user);
    void DeleteClient(int id);
    void UpdateClient (User user);
    List<User> ReadClient();
    int GetMaxId();
    void SortById();
    void SortByName();
}
