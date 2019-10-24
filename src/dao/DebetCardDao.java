package dao;

import beans.DebetCard;

import java.util.List;

public interface DebetCardDao {
    void AddDebetCard(DebetCard debetCard);
    void DeleteDebetCard(int cardnumber);
    void UpdateCreditCard(DebetCard debetCard);
    List<DebetCard> ReadCreditCard();
}
