package services;

import beans.CreditCard;
import beans.PaymentCard;

import java.util.List;

public interface CreditCardService {
    void AddCreditCard(CreditCard creditCard);
    void DeleteCreditCard(int cardnumber);
    void UpdateCreditCard(CreditCard creditCard);
    CreditCard SearchByName(String name);
    List<PaymentCard> ReadCreditCard();
}
