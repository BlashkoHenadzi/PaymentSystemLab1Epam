package dao.impl;

import beans.CreditCard;
import dao.CreditCardDao;

import java.beans.*;
import java.io.*;
import java.time.LocalDate;
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
        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
            //FileOutputStream outputStream = new FileOutputStream(file_path);
            XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream(file_path)));
            xmlEncoder.setPersistenceDelegate(LocalDate.class,
                    new PersistenceDelegate() {
                        @Override
                        protected Expression instantiate(Object localDate, Encoder encdr) {
                            return new Expression(localDate,
                                    LocalDate.class,
                                    "parse",
                                    new Object[]{localDate.toString()});
                        }
                    });
            xmlEncoder.writeObject(creditCardList);
            xmlEncoder.close();
            //outputStream.close();

        }
        catch (IOException e){

        }
    }
    private void readCreditCardsFromFile() {
        try{
           FileInputStream inputStream = new FileInputStream(file_path);
            XMLDecoder xmlDecoder = new XMLDecoder(inputStream);
            creditCardList = (ArrayList<CreditCard>)xmlDecoder.readObject();

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
