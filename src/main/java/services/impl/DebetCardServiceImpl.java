package services.impl;

import beans.DebitCard;
import beans.PaymentCard;
import dao.DebitCardDao;
import dao.factory.DaoFactory;
import services.DebetCardService;

import java.util.List;

public class DebetCardServiceImpl implements DebetCardService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    DebitCardDao debitCardDao = daoFactory.getDebetCardDAO();
    @Override
    public void AddDebetCard(DebitCard debitCard) {
        if (debitCard.getCardNumber()>0&& debitCard.getCardholderName().length()>1&&
                debitCard.getCardholderSurname().length()>1)
            debitCardDao.AddDebitCard(debitCard);

    }

    @Override
    public void DeleteDebetCard(int cardnumber) {
      debitCardDao.DeleteDebitCard(cardnumber);
    }

    @Override
    public void UpdateDebetCard(DebitCard debitCard) {
        if (debitCard !=null)
            debitCardDao.UpdateCreditCard(debitCard);
    }

    @Override
    public List<PaymentCard> ReadDebetCard() {
        return debitCardDao.ReadCreditCard();
    }
}
