package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;

@XmlType(name = "debit-card")
@XmlAccessorType(XmlAccessType.FIELD)
public class DebitCard extends PaymentCard {

    @XmlElement(name = "account-number", required = true)
    private int accountNumber;

    public DebitCard() {

    }

    public DebitCard(int cardNumber, LocalDate validThru, int balance, String cardholderName, String cardholderSurname,
                     int accountNumber) {
        super(cardNumber, validThru, balance, cardholderName, cardholderSurname);
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "accountNumber=" + accountNumber +
                "} " + super.toString();
    }

}