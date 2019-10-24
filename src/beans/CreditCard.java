package beans;

import java.time.LocalDate;

public class CreditCard extends PaymentCard {

    private int creditbalance;
    public CreditCard(int cardnumber, LocalDate validthrue, int balance, String cardholderName, String cardholderSurname,int creditbalance) {
        super(cardnumber, validthrue, balance, cardholderName, cardholderSurname);
        this.creditbalance = creditbalance;
    }

    public int getCreditbalance() {
        return creditbalance;
    }

    public void setCreditbalance(int creditbalance) {
        this.creditbalance = creditbalance;
    }

    @Override
    public String toString() {
        return "cardnamber"+getCardnumber()+"validthrue:"+getValidthrue()+"balance"+getBalance()+" "+getCardholderName()+" "+
                getCardholderSurname()+"creditbalance:"+creditbalance;
    }
}
