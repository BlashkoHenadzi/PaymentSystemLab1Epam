package dao;

import beans.CreditCard;
import beans.PaymentCard;

import java.util.List;

public interface CreditCardDao {

    void AddCreditCard(CreditCard creditCard);

    void DeleteCreditCard(int cardNumber);

    void UpdateCreditCard(CreditCard creditCard);

    CreditCard SearchByName(String name);

    List<PaymentCard> ReadCreditCard();

}