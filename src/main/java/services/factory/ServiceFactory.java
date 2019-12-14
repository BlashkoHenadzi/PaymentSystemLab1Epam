package services.factory;

import services.ClientService;
import services.CreditCardService;
import services.DebetCardService;
import services.impl.ClientServiceImpl;
import services.impl.CreditCardServiceImpl;
import services.impl.DebetCardServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private ClientService clientService ;
    private CreditCardService creditCardService ;
    private DebetCardService debetCardService;
    private ServiceFactory(){}
    public static ServiceFactory getInstance(){
        return instance;
    }
    public ClientService getClientService(){
        if (clientService ==null)
            clientService = new ClientServiceImpl();
        return clientService;
    }
    public CreditCardService getCcreditCardService(){
        if (creditCardService == null)
            creditCardService = new CreditCardServiceImpl();
        return creditCardService;
    }
    public DebetCardService getDebetCardService(){
        if (debetCardService==null)
            debetCardService = new DebetCardServiceImpl();
        return debetCardService;
    }
}
