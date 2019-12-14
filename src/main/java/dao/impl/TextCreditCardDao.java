package dao.impl;

import beans.Cards;
import beans.CreditCard;
import beans.PaymentCard;
import dao.CreditCardDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.beans.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TextCreditCardDao implements CreditCardDao {
    private Cards creditCardList;
    private static String file_path = "creditCards.xml";
    public TextCreditCardDao(){
        creditCardList = new Cards();
        if (new File(file_path).exists()){
            try {
                readCreditCardsFromFile();
            }
            catch (Exception e){

            }
        }
    }
    private void writeCreditsToFile() {
        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
            JAXBContext context = JAXBContext.newInstance(Cards.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(creditCardList, new File("creditCards.xml"));
        }
        catch (IOException e){
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private void readCreditCardsFromFile() {
        try{
            JAXBContext context = JAXBContext.newInstance(Cards.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            creditCardList = (Cards) unmarshaller.unmarshal(new File("creditCards.xml"));

        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AddCreditCard(CreditCard creditCard) {
        creditCardList.getCards().add(creditCard);
        writeCreditsToFile();
    }

    @Override
    public void DeleteCreditCard(int cardNumber) {
        for (PaymentCard elem:creditCardList.getCards()) {
            if (elem.getCardNumber() == cardNumber) {
                creditCardList.getCards().remove(elem);
                writeCreditsToFile();
                break;
            }

        }
    }

    @Override
    public void UpdateCreditCard(CreditCard creditCard) {
        for (PaymentCard creditCardelem :creditCardList.getCards()){
            if (creditCardelem.getCardNumber() == creditCard.getCardNumber()){
                creditCardList.getCards().set(creditCardList.getCards().indexOf(creditCardelem), creditCard);
                writeCreditsToFile();
                break;

        }
    }
    }

    @Override
    public CreditCard SearchByName(String name) {

        for (PaymentCard creditCard:creditCardList.getCards()) {
            if (creditCard.getCardholderName().equalsIgnoreCase(name))
                return (CreditCard)creditCard;


        }
        return null;
    }

    @Override
    public List<PaymentCard> ReadCreditCard() {
        return creditCardList.getCards();
    }

}
