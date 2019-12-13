package dao.impl;

import beans.Client;
import com.thoughtworks.xstream.XStream;
import dao.ClientDao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextClientDao implements ClientDao {
    private static String file_path = "clients.xml";
    private List<Client> clientList;
    public TextClientDao(){
        clientList = new ArrayList<Client>();
        if (new File(file_path).exists()){
            try {
                readClientsFromFile();
            }
            catch (Exception e){

            }
        }
    }

    private void readClientsFromFile() {
        try{
            XStream xStream = new XStream();
            xStream.registerConverter(new LocalDateConverter());
            FileInputStream inputStream = new FileInputStream(file_path);
            clientList = new ArrayList<Client>() ;
            xStream.fromXML(inputStream,clientList);

        }
        catch (IOException e){

        }
    }
    private void writeClientsToFile() {
        XStream xStream = new XStream();

        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
            xStream.registerConverter(new LocalDateConverter());
            xStream.toXML(clientList,new FileWriter(file_path));

        }
        catch (IOException e){

        }
    }

    @Override
    public void AddClient(Client client) {
        clientList.add(client);
        writeClientsToFile();
    }

    public List<Client> sortId() {
         clientList.sort(new SortClientById());
         return clientList;
    }


    @Override
    public void DeleteClient(int id) {
        for (Client elem:clientList) {
            if (elem.getId() == id) {
                clientList.remove(elem);
                writeClientsToFile();
                break;
            }

        }
    }

    @Override
    public void UpdateClient(Client client) {
        for (Client clientelem :clientList){
            if (client.getId() == clientelem.getId()) {
                clientList.set(clientList.indexOf(clientelem), client);
                writeClientsToFile();
                break;
            }
        }
    }

    @Override
    public List<Client> ReadClient() {

        return clientList;
    }
    public void SortById(){
        clientList.sort(new SortClientById());
    }
    public void SortByName(){
        clientList.sort(new SortClientByName());
    }

}
