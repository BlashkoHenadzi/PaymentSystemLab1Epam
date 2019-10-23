package dao.factory;

import beans.CreditCard;
import beans.DebetCard;
import dao.ClientDao;
import dao.CreditCardDao;
import dao.DebetCardDao;
import dao.impl.TextClientDao;
import dao.impl.TextCreditCardDao;
import dao.impl.TextDebetCardDao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private ClientDao textClientDao ;
    private CreditCardDao textCreditCardDao ;
    private DebetCardDao textDebetCardDao;
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        return instance;
    }
    public ClientDao getClientDAO(){
        if (textClientDao ==null)
            textClientDao = new TextClientDao();
        return textClientDao;
    }
    public CreditCardDao getCreditCardDAO(){
        if (textCreditCardDao == null)
            textCreditCardDao = new TextCreditCardDao();
        return textCreditCardDao;
    }
    public DebetCardDao getDebetCardDAO(){
        if (textDebetCardDao==null)
            textDebetCardDao = new TextDebetCardDao();
        return textDebetCardDao;
    }
}
