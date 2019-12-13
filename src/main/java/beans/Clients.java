package beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "clients", propOrder = {
        "clients"
})
public class Clients {
    @XmlElements({
            @XmlElement(name = "client", type = Client.class)
    })
    private List<Client> clients = new ArrayList<Client>();
    public List<Client> getClientList(){
        return clients;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
