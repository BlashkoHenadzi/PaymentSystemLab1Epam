package parsers;

import controller.Commands;
import controller.Controller;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
public class StAXParser {
    private static StAXParser ourInstance = new StAXParser();
    private DocumentBuilder documentBuilder;
    public static StAXParser getInstance() {
        return ourInstance;    }
    private XMLInputFactory inputFactory; ;
    public StAXParser() {
        PropertyConfigurator.configure("log4j.properties");
        inputFactory = XMLInputFactory.newInstance();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException("Error in initialize StAX Parser" + e);
        }

    }

    private final static Logger logger = Logger.getLogger(StAXParser.class);

    public  void getData(String path,Class elementClass) throws ParserException {
        Document document = null;
        try {
            document = documentBuilder.parse(path);
            Element element = document.getDocumentElement();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        Class annotationType = elementClass.getAnnotation(XmlType.class).annotationType();
        String elementTagName = null;
        try {
            elementTagName = annotationType.getDeclaredMethod("name",  null).invoke(elementClass.getAnnotation(XmlType.class),
                    (Object[]) null).toString();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        logger.info("start StAX");
        FileInputStream inputStream;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(path));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamReader.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(elementTagName)) {
                        buildElement(reader,elementTagName);
                    }

                }
                if (type ==XMLStreamReader.END_ELEMENT){
                    name = reader.getLocalName();
                    if (!name.equals(elementTagName)) {
                        return;
                    }
                }

            }

        } catch (XMLStreamException e) {
            throw new ParserException("" + e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private boolean buildElement(XMLStreamReader reader,String elementTagName) throws XMLStreamException, ParserException {
        String name;
        String request="";
        if ((reader.getAttributeName(0)!=null) && !reader.getAttributeName(0).toString().equals("id"))
            request += reader.getAttributeValue(0) + ",";
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    request+=getXMLText(reader)+",";

                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(elementTagName)) {
                        SendRequest(elementTagName,request);
                        return true;
                    }
                    break;
            }


        }
        throw new ParserException("Unknown element in flower");
    }
    private void SendRequest(String elementTagName, String request) {
        Controller controller = new Controller();
        int commandId = Commands.getValueFromName("add " + elementTagName).getID();
            controller.command(new String[]{String.valueOf(commandId), request});
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }


}
