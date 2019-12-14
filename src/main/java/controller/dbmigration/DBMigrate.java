package controller.dbmigration;

import beans.Client;
import beans.CreditCard;
import beans.DebitCard;
import beans.PaymentCard;
import dao.factory.DaoFactory;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


public class DBMigrate {
    DBController dbController;
    public DBMigrate(){
    dbController = new DBController("root","","PaymentSystem","localhost");
    dbController.Connect();

    }
    public boolean SendToDB(){
        if(
        ValidateXmlFiles(new File("clients.xml"),new File("clxsd.xsd"))
        &&ValidateXmlFiles(new File("creditCards.xml"),new File("cards.xsd"))
        &&ValidateXmlFiles(new File("debitCards.xml"),new File("cards.xsd"))) {
            ParseLists();
            dbController.Disconnect();
            return true;
        }
        return false;

    }

    private void ParseLists() {
        for (PaymentCard paymentCard:DaoFactory.getInstance().getCreditCardDAO().ReadCreditCard()) {
            dbController.AddCreditCardToDB((CreditCard)paymentCard);
        }
        for (PaymentCard paymentCard:DaoFactory.getInstance().getDebetCardDAO().ReadCreditCard()){
            dbController.AddDebitCardToDB((DebitCard)paymentCard);
        }
        for(Client client:DaoFactory.getInstance().getClientDAO().ReadClient()){
            dbController.AddClientToDB(client);
        }

    }

    private boolean ValidateXmlFiles(File xmlfile, File xsdfile){
        try {
            Validator validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsdfile).newValidator();
            validator.validate(new StreamSource((xmlfile)));
            return true;

        }
        catch (Exception e){

        }
        return  false;
}
}
