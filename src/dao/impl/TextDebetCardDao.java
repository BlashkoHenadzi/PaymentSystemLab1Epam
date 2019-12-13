package dao.impl;


import beans.DebetCard;
import dao.DebetCardDao;
import com.thoughtworks.xstream.XStream;
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
            debetCardList = new ArrayList<DebetCard>();
            XStream xStream = new XStream();
            xStream.registerConverter(new LocalDateConverter());
            xStream.fromXML(inputStream,debetCardList);


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

            XStream xStream = new XStream();
            xStream.registerConverter(new LocalDateConverter());
            xStream.toXML(debetCardList,new FileWriter(file_path));
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
