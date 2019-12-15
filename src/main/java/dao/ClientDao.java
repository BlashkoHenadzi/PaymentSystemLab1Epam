package dao;

import beans.User;

import java.util.List;

public interface ClientDao {
    void AddClient(User user);
    void DeleteClient(int id);
    void UpdateClient (User user);
    void SortById();
    void SortByName();
    List<User> ReadClient();
}
