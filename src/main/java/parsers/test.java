package parsers;

import beans.User;
import beans.CreditCard;
import beans.DebitCard;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
//        DOMParser domParser = new DOMParser();
//        domParser.getData("clients.xml",User.class);
//        domParser.getData("creditCards.xml", CreditCard.class);
//        domParser.getData("debitCards.xml", DebitCard.class);
        StAXParser saxParser = new StAXParser();
        Validator validator = null;
        try {
            validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("clxsd.xsd")).newValidator();
            validator.validate(new StreamSource(("clients.xml")));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       saxParser.getData("clients.xml", User.class);
        saxParser.getData("creditCards.xml", CreditCard.class);
        saxParser.getData("debitCards.xml", DebitCard.class);


    }

}