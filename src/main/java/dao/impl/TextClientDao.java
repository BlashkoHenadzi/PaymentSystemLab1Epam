package dao.impl;

import beans.User;
import beans.Clients;
import dao.ClientDao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

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
    public void AddClient(User user) {
        clientList.getClientList().add(user);
        writeClientsToFile();
    }

    public List<User> sortId() {
         clientList.getClientList().sort(new SortClientById());
         return clientList.getClientList();
    }


    @Override
    public void DeleteClient(int id) {
        for (User elem:clientList.getClientList()) {
            if (elem.getId() == id) {
                clientList.getClientList().remove(elem);
                writeClientsToFile();
                break;
            }

        }
    }

    @Override
    public void UpdateClient(User user) {
        for (User clientelem :clientList.getClientList()){
            if (user.getId() == clientelem.getId()) {
                clientList.getClientList().set(clientList.getClientList().indexOf(clientelem), user);
                writeClientsToFile();
                break;
            }
        }
    }

    @Override
    public List<User> ReadClient() {

        return clientList.getClientList();
    }
    public void SortById(){
        clientList.getClientList().sort(new SortClientById());
    }
    public void SortByName(){
        clientList.getClientList().sort(new SortClientByName());
    }

}
