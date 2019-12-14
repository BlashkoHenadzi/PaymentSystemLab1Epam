package beans;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlType(name = "payment-card", propOrder = {
        "validThru",
        "balance",
        "cardholderName",
        "cardholderSurname"
})
@XmlSeeAlso({
        CreditCard.class,
        DebitCard.class
})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class PaymentCard {

    @XmlAttribute(name = "card-number", required = true)
    private int cardNumber;
    @XmlElement(name = "valid-thru", required = true)
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate validThru;
    @XmlElement(name = "balance", required = true)
    private int balance;
    @XmlElement(name = "card-holder-name", required = true)
    private String cardholderName;
    @XmlElement(name = "card-holder-surname", required = true)
    private String cardholderSurname;

    public PaymentCard() {

    }

    public PaymentCard(int cardNumber, LocalDate validThru, int balance, String cardholderName, String cardholderSurname) {
        this.cardholderName = cardholderName;
        this.balance = balance;
        this.validThru = validThru;
        this.cardNumber = cardNumber;
        this.cardholderSurname = cardholderSurname;

    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getValidThru() {
        return validThru;
    }

    public void setValidThru(LocalDate validThru) {
        this.validThru = validThru;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardholderSurname() {
        return cardholderSurname;
    }

    public void setCardholderSurname(String cardholderSurname) {
        this.cardholderSurname = cardholderSurname;
    }

    @Override
    public String toString() {
        return "PaymentCard{" +
                "cardNumber=" + cardNumber +
                ", validThru=" + validThru +
                ", balance=" + balance +
                ", cardholderName='" + cardholderName + '\'' +
                ", cardholderSurname='" + cardholderSurname + '\'' +
                '}';
    }
}
