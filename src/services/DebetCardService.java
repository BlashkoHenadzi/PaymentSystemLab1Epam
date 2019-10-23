package services;

import beans.DebetCard;

import java.util.List;

public interface DebetCardService {
    void AddDebetCard(DebetCard debetCard);
    void DeleteDebetCard(DebetCard debetCard);
    void UpdateCreditCard(DebetCard debetCard);
    List<DebetCard> ReadCreditCard();
}
