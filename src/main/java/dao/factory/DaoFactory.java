package dao.factory;

import dao.ClientDao;
import dao.CreditCardDao;
import dao.DebitCardDao;
import dao.impl.TextClientDao;
import dao.impl.TextCreditCardDao;
import dao.impl.TextDebitCardDao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private ClientDao textClientDao ;
    private CreditCardDao textCreditCardDao ;
    private DebitCardDao textDebitCardDao;
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
    public DebitCardDao getDebetCardDAO(){
        if (textDebitCardDao ==null)
            textDebitCardDao = new TextDebitCardDao();
        return textDebitCardDao;
    }
}
