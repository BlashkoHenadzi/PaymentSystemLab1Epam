package services;

import beans.DebetCard;

import java.util.List;

public interface DebetCardService {
    void AddDebetCard(DebetCard debetCard);
    void DeleteDebetCard(int cardnumber);
    void UpdateDebetCard(DebetCard debetCard);
    List<DebetCard> ReadDebetCard();
}
