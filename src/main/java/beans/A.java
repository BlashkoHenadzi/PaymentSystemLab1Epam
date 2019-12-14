package beans;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class A extends SchemaOutputResolver {

    @Override
    public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
        suggestedFileName = "C:\\Users\\USER\\IdeaProjects\\PaymentSystemLab1Epam\\clxsd.xsd";
        File file = new File(suggestedFileName);
        StreamResult result = new StreamResult();
        result.setSystemId(file.toURI().toURL().toString());
        return result;
    }

    public static void main(String[] args) throws JAXBException, IOException, SAXException {
//        JAXBContext context = JAXBContext.newInstance(Clients.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
     //   Marshaller marshaller = context.createMarshaller();
//        Cards c = new Cards();
//        LocalDate validthrue = LocalDate.parse("2010-10-10");
//        PaymentCard cs = new DebitCard(111,validthrue,5,"gena","lox",4);
//        PaymentCard dc = new CreditCard(222,validthrue,6,"pasha","wdqdwq",5);
//        c.getCards().add(cs);
//        c.getCards().add(dc);
//        marshaller.marshal(c, new File("cards.xml"));


       // Cards cards = (Cards) unmarshaller.unmarshal(new File("C:\\Users\\USER\\IdeaProjects\\PaymentSystemLab1Epam\\cards.xml"));
       // System.out.println(cards.toString());
//        /A a = new A();
//        context.generateSchema(a);
    }

}
