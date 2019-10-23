package dao.impl;

import beans.Client;
import dao.ClientDao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextClientDao implements ClientDao {
    private static String file_path = "clients.xml";
    private ArrayList<Client> clientList;
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
                FileOutputStream outputStream = new FileOutputStream(file_path);
                XMLEncoder xmlEncoder = new XMLEncoder(outputStream);
                xmlEncoder.writeObject(clientList);
                xmlEncoder.close();
                outputStream.close();

        }
        catch (IOException e){

        }
    }

    @Override
    public void AddClient(Client client) {
        clientList.add(client);
        writeClientsToFile();
    }



    @Override
    public void DeleteClient(Client client) {

        clientList.remove(client);
    }

    @Override
    public void UpdateClient(Client client) {
        //todo
    }

    @Override
    public List<Client> ReadClient() {
        return clientList;
    }

}
