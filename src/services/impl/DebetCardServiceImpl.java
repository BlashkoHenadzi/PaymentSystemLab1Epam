package services.impl;

import beans.DebetCard;
import dao.DebetCardDao;
import dao.factory.DaoFactory;
import services.DebetCardService;

import java.util.List;

public class DebetCardServiceImpl implements DebetCardService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    DebetCardDao debetCardDao = daoFactory.getDebetCardDAO();
    @Override
    public void AddDebetCard(DebetCard debetCard) {
        if (debetCard.getCardnumber()>0&&debetCard.getCardholderName().length()>1&&
                debetCard.getCardholderSurname().length()>1)
            debetCardDao.AddDebetCard(debetCard);
    }

    @Override
    public void DeleteDebetCard(int cardnumber) {
      debetCardDao.DeleteDebetCard(cardnumber);
    }

    @Override
    public void UpdateCreditCard(DebetCard debetCard) {
        if (debetCard!=null)
            debetCardDao.UpdateCreditCard(debetCard);
    }

    @Override
    public List<DebetCard> ReadCreditCard() {
        return debetCardDao.ReadCreditCard();
    }
}
