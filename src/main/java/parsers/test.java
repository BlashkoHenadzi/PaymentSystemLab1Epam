package parsers;

import beans.Client;
import beans.CreditCard;
import beans.DebitCard;

public class test {

    public static void main(String[] args) {
//        DOMParser domParser = new DOMParser();
//        domParser.getData("clients.xml",Client.class);
//        domParser.getData("creditCards.xml", CreditCard.class);
//        domParser.getData("debitCards.xml", DebitCard.class);
        SAXParser saxParser = new SAXParser();
        saxParser.getData("clients.xml",Client.class);
        saxParser.getData("creditCards.xml", CreditCard.class);
        saxParser.getData("debitCards.xml", DebitCard.class);


    }

}