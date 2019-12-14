package dao.impl;

import beans.CreditCard;
import services.factory.ServiceFactory;

public class SearchCreditCardByName {
    public CreditCard SearchCreditCardByName(String name){
        return  ServiceFactory.getInstance().getCcreditCardService().SearchByName(name);
    }
}
