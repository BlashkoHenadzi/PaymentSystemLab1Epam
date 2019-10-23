package beans;

import java.time.LocalDate;

public class DebetCard extends PaymentCard {
private int accountnumber;

    public DebetCard(int cardnumber, LocalDate validthrue, int balance, String cardholderName, String cardholderSurname,int accountnumber) {
        super(cardnumber, validthrue, balance, cardholderName, cardholderSurname);
        this.accountnumber = accountnumber;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }
}

