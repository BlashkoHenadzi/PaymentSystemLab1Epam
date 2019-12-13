package dao.impl;

import beans.CreditCard;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.thoughtworks.xstream.XStream;
import dao.CreditCardDao;

import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextCreditCardDao implements CreditCardDao {
    private List<CreditCard> creditCardList;
    private static String file_path = "creditcards.xml";
    public TextCreditCardDao(){
        creditCardList = new ArrayList<CreditCard>();
        if (new File(file_path).exists()){
            try {
                readCreditCardsFromFile();
            }
            catch (Exception e){

            }
        }
    }
    private void writeCreditsToFile() {
        XStream xStream = new XStream();

        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
            xStream.registerConverter(new LocalDateConverter());
            xStream.toXML(creditCardList,new FileWriter(file_path));

        }
        catch (IOException e){

        }
    }
    private void readCreditCardsFromFile() {
        try{
            XStream xStream = new XStream();
            xStream.registerConverter(new LocalDateConverter());
           FileInputStream inputStream = new FileInputStream(file_path);
            creditCardList = new ArrayList<CreditCard>() ;
            xStream.fromXML(inputStream,creditCardList);

        }
        catch (IOException e){

        }
    }

    @Override
    public void AddCreditCard(CreditCard creditCard) {
        creditCardList.add(creditCard);
        writeCreditsToFile();
    }

    @Override
    public void DeleteCreditCard(int id) {
        for (CreditCard elem:creditCardList) {
            if (elem.getCardnumber() == id) {
                creditCardList.remove(elem);
                writeCreditsToFile();
                break;
            }

        }
    }

    @Override
    public void UpdateCreditCard(CreditCard creditCard) {
        for (CreditCard creditCardelem :creditCardList){
            if (creditCardelem.getCardnumber() == creditCard.getCardnumber()){
                creditCardList.set(creditCardList.indexOf(creditCardelem), creditCard);
                writeCreditsToFile();
                break;

        }
    }
    }

    @Override
    public CreditCard SearchByName(String name) {

        for (CreditCard creditCard:creditCardList) {
            if (creditCard.getCardholderName().equalsIgnoreCase(name))
                return creditCard;


        }
        return null;
    }

    @Override
    public List<CreditCard> ReadCreditCard() {
        return creditCardList;
    }

}
