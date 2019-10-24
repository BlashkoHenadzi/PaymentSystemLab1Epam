package beans;

import java.io.Serializable;

public class Client   {
    private int id;
    private String name;
    private String surname;
    private int clientcardscount;
    public Client(){
    }
    public Client(String name, String surname, int clientcardscount,int id) {
        this.name = name;
        this.surname = surname;
        this.clientcardscount = clientcardscount;
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClientcardscount() {
        return clientcardscount;
    }

    public void setClientcardscount(int clientcardscount) {
        this.clientcardscount = clientcardscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "id:"+id + " " + name +" "+" "+ surname+" "+"cardscount:"+clientcardscount;
    }
}
