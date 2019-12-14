package services.impl;

import beans.CreditCard;
import beans.PaymentCard;
import dao.CreditCardDao;
import dao.factory.DaoFactory;
import services.CreditCardService;

import java.util.List;

public class CreditCardServiceImpl implements CreditCardService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    CreditCardDao creditCardDao = daoFactory.getCreditCardDAO();
    @Override
    public void AddCreditCard(CreditCard creditCard) {
        if (creditCard.getCardNumber()>0&&creditCard.getCardholderName().length()>1&&
                creditCard.getCardholderSurname().length()>1)
            creditCardDao.AddCreditCard(creditCard);
    }

    @Override
    public void DeleteCreditCard(int cardnumber) {
            creditCardDao.DeleteCreditCard(cardnumber);
    }

    @Override
    public void UpdateCreditCard(CreditCard creditCard) {
        if (creditCard!=null)
            creditCardDao.UpdateCreditCard(creditCard);
    }

    @Override
    public List<PaymentCard> ReadCreditCard() {
        return creditCardDao.ReadCreditCard();
    }
    public CreditCard SearchByName(String name){
        return creditCardDao.SearchByName(name);
    }



}
