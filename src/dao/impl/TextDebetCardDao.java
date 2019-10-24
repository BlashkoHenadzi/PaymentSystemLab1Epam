package dao.impl;


import beans.DebetCard;
import dao.DebetCardDao;

import java.beans.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TextDebetCardDao implements DebetCardDao {
    private List<DebetCard> debetCardList;
    private static String file_path = "debetcards.xml";
    public TextDebetCardDao(){
        debetCardList = new ArrayList<DebetCard>();
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
            debetCardList = (ArrayList<DebetCard>)xmlDecoder.readObject();

        }
        catch (IOException e){

        }
    }
    private void writeDebetsToFile() {
        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
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
            xmlEncoder.writeObject(debetCardList);
            xmlEncoder.close();
        }
        catch (IOException e){

        }
    }
    @Override
    public void AddDebetCard(DebetCard debetCard) {
        debetCardList.add(debetCard);
        writeDebetsToFile();
    }

    @Override
    public void DeleteDebetCard(int cardnumber) {
        for (DebetCard elem:debetCardList) {
            if (elem.getCardnumber() == cardnumber) {
                debetCardList.remove(elem);
                writeDebetsToFile();
                break;
            }

        }
    }

    @Override
    public void UpdateCreditCard(DebetCard debetCard) {
        for (DebetCard debetCardelem : debetCardList) {
            if (debetCardelem.getCardnumber() == debetCard.getCardnumber()) {
                debetCardList.set(debetCardList.indexOf(debetCardelem), debetCard);
                writeDebetsToFile();
                break;

            }
        }
    }

    @Override
    public List<DebetCard> ReadCreditCard() {
        return debetCardList;
    }


}
