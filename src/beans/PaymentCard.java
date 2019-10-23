package beans;

import java.time.LocalDate;

public abstract class PaymentCard {
    private int cardnumber;
    private LocalDate validthrue;
    private int balance;
    private String cardholderName;
    private String cardholderSurname;

    public  PaymentCard(int cardnumber, LocalDate validthrue, int balance, String cardholderName,String cardholderSurname){
        this.cardholderName = cardholderName;
        this.balance = balance;
        this.validthrue = validthrue;
        this.cardnumber = cardnumber;
        this.cardholderSurname = cardholderSurname;

    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public LocalDate getValidthrue() {
        return validthrue;
    }

    public void setValidthrue(LocalDate validthrue) {
        this.validthrue = validthrue;
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

}
