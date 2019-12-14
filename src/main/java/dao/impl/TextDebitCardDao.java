package dao.impl;


import beans.Cards;
import beans.DebitCard;
import beans.PaymentCard;
import dao.DebitCardDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.beans.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TextDebitCardDao implements DebitCardDao {
    private Cards debitCardList;
    private static String file_path = "debitCards.xml";
    public TextDebitCardDao(){
        debitCardList = new Cards();
        if (new File(file_path).exists()){
            try {
                readCreditCardsFromFile();
            }
            catch (Exception e){

            }
        }
    }

    private void readCreditCardsFromFile() {
        try{
            JAXBContext context = JAXBContext.newInstance(Cards.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            debitCardList = (Cards) unmarshaller.unmarshal(new File(file_path));
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private void writeDebetsToFile() {
        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
            JAXBContext context = JAXBContext.newInstance(Cards.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(debitCardList, new File(file_path));
        }
        catch (IOException e){
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void AddDebitCard(DebitCard debitCard) {
        debitCardList.getCards().add(debitCard);
        writeDebetsToFile();
    }

    @Override
    public void DeleteDebitCard(int cardNumber) {
        for (PaymentCard elem: debitCardList.getCards()) {
            if (elem.getCardNumber() == cardNumber) {
                debitCardList.getCards().remove(elem);
                writeDebetsToFile();
                break;
            }

        }
    }

    @Override
    public void UpdateCreditCard(DebitCard debitCard) {
        for (PaymentCard debitCardelem : debitCardList.getCards()) {
            if (debitCardelem.getCardNumber() == debitCard.getCardNumber()) {
                debitCardList.getCards().set(debitCardList.getCards().indexOf(debitCardelem), debitCard);
                writeDebetsToFile();
                break;

            }
        }
    }

    @Override
    public List<PaymentCard> ReadCreditCard() {
        return debitCardList.getCards();
    }


}
