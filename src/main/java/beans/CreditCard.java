package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;

@XmlType(name = "credit-card")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard extends PaymentCard {

    @XmlElement(name = "credit-balance", required = true)
    private int creditBalance;

    public CreditCard() {

    }

    public CreditCard(int cardNumber, LocalDate validThru, int balance, String cardholderName, String cardholderSurname, int creditBalance) {
        super(cardNumber, validThru, balance, cardholderName, cardholderSurname);
        this.creditBalance = creditBalance;
    }

    public int getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(int creditBalance) {
        this.creditBalance = creditBalance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditBalance=" + creditBalance +
                "} " + super.toString();
    }

}