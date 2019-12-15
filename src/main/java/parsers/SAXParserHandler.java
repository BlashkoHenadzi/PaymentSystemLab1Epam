package parsers;

import controller.Commands;
import controller.Controller;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SAXParserHandler extends DefaultHandler {
    private final String path;
    private String content;
    private String request;
    private String elementNameTag;
    private ArrayList<String> requests;
    private Element element;
    private Class type;
    private static SAXParser ourInstance;
    private DocumentBuilder documentBuilder;

    public SAXParserHandler(String path, Class type) {
        this.path = path;
        this.type = type;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException("Error in initialize SAX Parser" + e);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        Document document = null;
        try {
            document = documentBuilder.parse(path);
            Element element = document.getDocumentElement();
            Class annotationType = type.getAnnotation(XmlType.class).annotationType();
            elementNameTag = annotationType.getDeclaredMethod("name", null).invoke(type.getAnnotation(XmlType.class),
                    (Object[]) null).toString();
            requests = new ArrayList<>();
            this.element = (Element) element.getElementsByTagName(elementNameTag).item(0);
        } catch (IOException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals(elementNameTag)) {
            request = "";
            if ((attributes.getLength() > 0) && !attributes.getQName(0).equals("id"))
                request += attributes.getValue(0) + ",";
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (((Element) element.getElementsByTagName(qName).item(0)) != null)
            request += content + ",";
        if (qName.equals(elementNameTag))
            requests.add(request);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }


    public boolean SendRequests() {
        Controller controller = new Controller();
        int commandId = Commands.getValueFromName("add " + elementNameTag).getID();
        for (String request : requests) {
            controller.command(new String[]{String.valueOf(commandId), request});
        }

        return true;
    }
}
