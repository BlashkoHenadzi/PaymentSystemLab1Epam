package beans;

import javax.xml.bind.annotation.*;

@XmlType(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    @XmlAttribute(name = "id", required = true)
    private int id;
    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(name = "surname", required = true)
    private String surname;
    @XmlElement(name = "client-cards-count", required = true)
    private int clientCardsCount;

    public Client() {

    }

    public Client(String name, String surname, int clientCardsCount, int id) {
        this.name = name;
        this.surname = surname;
        this.clientCardsCount = clientCardsCount;
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

    public int getClientCardsCount() {
        return clientCardsCount;
    }

    public void setClientCardsCount(int clientCardsCount) {
        this.clientCardsCount = clientCardsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", clientCardsCount=" + clientCardsCount +
                '}';
    }

}