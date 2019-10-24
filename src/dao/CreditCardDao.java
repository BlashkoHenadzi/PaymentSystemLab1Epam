package dao;

import beans.CreditCard;

import java.util.List;

public interface CreditCardDao {
    void AddCreditCard(CreditCard creditCard);
    void DeleteCreditCard(int cardnumber);
    void UpdateCreditCard(CreditCard creditCard);
    List<CreditCard> ReadCreditCard();
}
