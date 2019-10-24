package dao.impl;

import beans.Client;
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
            FileInputStream inputStream = new FileInputStream(file_path);
            XMLDecoder xmlDecoder = new XMLDecoder(inputStream);
            clientList = (ArrayList<Client>)xmlDecoder.readObject();

        }
        catch (IOException e){

        }
    }
    private void writeClientsToFile() {
        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
                //FileOutputStream outputStream = new FileOutputStream(file_path);
                XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                        new FileOutputStream(file_path)));
                xmlEncoder.writeObject(clientList);
                xmlEncoder.close();
                //outputStream.close();

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
