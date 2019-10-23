package dao;

import beans.CreditCard;

import java.util.List;

public interface CreditCardDao {
    void AddCreditCard(CreditCard creditCard);
    void DeleteCreditCard(CreditCard creditCard);
    void UpdateCreditCard(CreditCard creditCard);
    List<CreditCard> ReadCreditCard();
}
