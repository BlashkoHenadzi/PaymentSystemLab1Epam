package dao.impl;

import beans.Client;
import dao.ClientDao;

import java.util.Comparator;

public class SortClientByName implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return  o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
