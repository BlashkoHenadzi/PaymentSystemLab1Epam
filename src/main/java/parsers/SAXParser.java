package parsers;

import controller.Commands;
import controller.Controller;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParser {
    private final static Logger logger = Logger.getLogger(DOMParser.class);



    public SAXParser(){
        PropertyConfigurator.configure("log4j.properties");

    }
    public boolean getData(String path, Class type) throws ParserException {
        logger.info("Start SAX");

        try {

            SAXParserFactory factoryParser = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factoryParser.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler(path,type);
            File file = new File(path);
            parser.parse(file, handler);
            handler.SendRequests();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

}
