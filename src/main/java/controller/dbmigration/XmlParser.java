//package controller.dbmigration;
//import beans.CreditCard;
//import org.w3c.dom.Document;
//import org.w3c.dom.NamedNodeMap;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.io.File;
//import java.time.LocalDate;
//
//public  class XmlParser {
//    public static void ParseXmlCreditCards(File xmlfile,DBController dbController) {
//        Document document=null;
//        try {
//            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
//            document = documentBuilder.parse(xmlfile);
//        } catch (Exception e) {
//            document = 1;
//        }
//        if(document!=null){
//        NodeList nodeList = document.getElementsByTagName("object");
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node node = nodeList.item(i);
//            if (Node.ELEMENT_NODE == node.getNodeType()&&node.get) {
//                int creditbalance = Integer.parseInt(getTextContent(node, "creditbalance"));
//                int cardnumber = Integer.parseInt(getTextContent(node, "cardnumber"));
//                LocalDate validthrue = LocalDate.parse(getTextContent(node,"validthrue"));
//                int balance = Integer.parseInt(getTextContent(node, "balance"));
//                String cardholderName = getTextContent(node, "cardholderName");
//                String cardholderSurname = getTextContent(node, "cardholderSurname");
//                CreditCard creditCard = new CreditCard();
//                creditCard.setCreditBalance(creditbalance);
//                creditCard.setBalance(balance);
//                creditCard.setCardholderName(cardholderName);
//                creditCard.setCardholderSurname(cardholderSurname);
//                creditCard.setCardNumber(cardnumber);
//                creditCard.setValidThru(validthrue);
//
//
//                dbController.AddCreditCardToDB(creditCard);
//            }
//    }}}
//    private static String getTextContent(Node parentNode,String childName)
//    {
//        NodeList nlist = parentNode.getChildNodes();
//        for (int i = 0 ; i < nlist.getLength() ; i++) {
//            Node n = nlist.item(i);
//            String name = n.getNodeName();
//            if ( name != null && name.equals(childName) )
//                return n.getTextContent();
//        }
//        return "";
//    }
//
//    private static String getAttrValue(Node node, String attrName)
//    {
//        if ( ! node.hasAttributes() ) return "";
//        NamedNodeMap nmap = node.getAttributes();
//        if ( nmap == null ) return "";
//        Node n = nmap.getNamedItem(attrName);
//        if ( n == null ) return "";
//        return n.getNodeValue();
//    }
//
//}