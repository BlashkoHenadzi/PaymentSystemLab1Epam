package services.impl;

import beans.CreditCard;
import dao.CreditCardDao;
import dao.factory.DaoFactory;
import services.CreditCardService;

import java.util.List;

public class CreditCardServiceImpl implements CreditCardService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    CreditCardDao creditCardDao = daoFactory.getCreditCardDAO();
    @Override
    public void AddCreditCard(CreditCard creditCard) {
        if (creditCard.getCardnumber()>0&&creditCard.getCardholderName().length()>1&&
                creditCard.getCardholderSurname().length()>1)
            creditCardDao.AddCreditCard(creditCard);
    }

    @Override
    public void DeleteCreditCard(CreditCard creditCard) {
        if (creditCard!=null)
            creditCardDao.DeleteCreditCard(creditCard);
    }

    @Override
    public void UpdateCreditCard(CreditCard creditCard) {
        if (creditCard!=null)
            creditCardDao.UpdateCreditCard(creditCard);
    }

    @Override
    public List<CreditCard> ReadCreditCard() {
        return creditCardDao.ReadCreditCard();
    }
}
