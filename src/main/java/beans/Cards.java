package beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "cards", propOrder = {
        "cards"
})
public class Cards {

    @XmlElements({
            @XmlElement(name = "credit-card", type = CreditCard.class),
            @XmlElement(name = "debit-card", type = DebitCard.class)
    })
    private List<PaymentCard> cards = new ArrayList<>();

    public List<PaymentCard> getCards() {
        return cards;
    }
    @Override
    public String toString() {
        return "Cards{" +
                "cards=" + cards +
                '}';
    }

}