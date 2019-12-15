package parsers;

import controller.Command;
import controller.CommandProvider;
import controller.Commands;
import controller.Controller;
import dao.factory.DaoFactory;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMParser {
    private final static Logger logger = Logger.getLogger(DOMParser.class);
    private static DOMParser ourInstance;
    private DocumentBuilder documentBuilder;

    static {
        try {
            ourInstance = new DOMParser();
        } catch (ParserException e) {
            logger.error("DOMParser creating error");
        }
    }

    public static DOMParser getInstance() {
        return ourInstance;
    }

    public DOMParser() {


    }

    public boolean getData(String path, Class type) throws ParserException {
        logger.info("Start DOM");
        Document document;
        try {
            document = documentBuilder.parse(path);
            Element element = document.getDocumentElement();
            Class annotationType = type.getAnnotation(XmlType.class).annotationType();
            String elementTagName = annotationType.getDeclaredMethod("name",  null).invoke(type.getAnnotation(XmlType.class),
                    (Object[]) null).toString();
            NodeList nodeList = element.getElementsByTagName(elementTagName);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element1 = (Element) nodeList.item(i);
                buildElement(element1, elementTagName);
            }
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    private boolean buildElement(Element element, String elementTagName) {
        Controller controller = new Controller();
        int commandId = Commands.getValueFromName("add " + elementTagName).getID();
        String[] parametersList = controller.getCommandParameters(commandId);
        String request = "";
        for (String parameter : parametersList) {
            request += getElementTextContent(element, parameter) + ",";
        }
        controller.command(new String[]{String.valueOf(commandId), request});
        return true;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Element element1;
        Node node = nList.item(0);
        String text;
        if (node != null) {
             text = node.getTextContent();
        } else
            text = element.getAttribute(elementName);
            logger.info("Add to  " + text);
        return text;
    }
}