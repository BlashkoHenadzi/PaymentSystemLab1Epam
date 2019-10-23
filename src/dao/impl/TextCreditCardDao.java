package dao.impl;

import beans.CreditCard;
import dao.CreditCardDao;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
    }

    @Override
    public void DeleteCreditCard(CreditCard creditCard) {
        creditCardList.remove(creditCard);
    }

    @Override
    public void UpdateCreditCard(CreditCard creditCard) {
        for (CreditCard creditCardelem :creditCardList){
            if (creditCardelem.getCardnumber() == creditCard.getCardnumber())
                creditCardelem = creditCard;

        }
    }

    @Override
    public List<CreditCard> ReadCreditCard() {
        return creditCardList;
    }

}
