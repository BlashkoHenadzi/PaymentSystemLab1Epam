package dao.impl;


import beans.DebetCard;
import dao.DebetCardDao;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

    @Override
    public void AddDebetCard(DebetCard debetCard) {
        debetCardList.add(debetCard);
    }

    @Override
    public void DeleteDebetCard(int cardnumber) {
        for (DebetCard elem:debetCardList) {
            if (elem.getCardnumber() == cardnumber)
                debetCardList.remove(elem);

        }
    }

    @Override
    public void UpdateCreditCard(DebetCard debetCard) {
        for (DebetCard debetCardelem :debetCardList){
            if (debetCardelem.getCardnumber() == debetCard.getCardnumber())
                debetCardelem = debetCard;

        }
    }

    @Override
    public List<DebetCard> ReadCreditCard() {
        return debetCardList;
    }


}
