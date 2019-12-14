package dao;

import beans.DebitCard;
import beans.PaymentCard;

import java.util.List;

public interface DebitCardDao {

    void AddDebitCard(DebitCard debitCard);

    void DeleteDebitCard(int cardNumber);

    void UpdateCreditCard(DebitCard debitCard);

    List<PaymentCard> ReadCreditCard();

}