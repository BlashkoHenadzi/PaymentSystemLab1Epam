package dao.impl;

import beans.Client;
import beans.Clients;
import dao.ClientDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

public class TextClientDao implements ClientDao {
    private static String file_path = "clients.xml";
    private Clients clientList;
    public TextClientDao(){
        clientList = new Clients();
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
            JAXBContext context = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            clientList = (Clients) unmarshaller.unmarshal(new File(file_path));

        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private void writeClientsToFile() {
        try {
            File file = new File(file_path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    throw new IOException();
            }
            JAXBContext context = JAXBContext.newInstance(Clients.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(clientList, new File(file_path));
        }
        catch (IOException e){
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AddClient(Client client) {
        clientList.getClientList().add(client);
        writeClientsToFile();
    }

    public List<Client> sortId() {
         clientList.getClientList().sort(new SortClientById());
         return clientList.getClientList();
    }


    @Override
    public void DeleteClient(int id) {
        for (Client elem:clientList.getClientList()) {
            if (elem.getId() == id) {
                clientList.getClientList().remove(elem);
                writeClientsToFile();
                break;
            }

        }
    }

    @Override
    public void UpdateClient(Client client) {
        for (Client clientelem :clientList.getClientList()){
            if (client.getId() == clientelem.getId()) {
                clientList.getClientList().set(clientList.getClientList().indexOf(clientelem), client);
                writeClientsToFile();
                break;
            }
        }
    }

    @Override
    public List<Client> ReadClient() {

        return clientList.getClientList();
    }
    public void SortById(){
        clientList.getClientList().sort(new SortClientById());
    }
    public void SortByName(){
        clientList.getClientList().sort(new SortClientByName());
    }

}
