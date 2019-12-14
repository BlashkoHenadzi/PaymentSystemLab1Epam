package services;

import beans.DebitCard;
import beans.PaymentCard;

import java.util.List;

public interface DebetCardService {
    void AddDebetCard(DebitCard debitCard);
    void DeleteDebetCard(int cardnumber);
    void UpdateDebetCard(DebitCard debitCard);
    List<PaymentCard> ReadDebetCard();
}
