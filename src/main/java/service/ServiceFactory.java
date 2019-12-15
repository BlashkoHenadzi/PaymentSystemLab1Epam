package service;

public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        if(instance == null) {
            instance = new ServiceFactory();
        }

        return instance;
    }


    public static UserService getUserService() {
        return UserService.getInstance();
    }

    public static AccountService getAccountService() {
        return AccountService.getInstance();
    }

    public static CardService getCardService() {
        return CardService.getInstance();
    }

    public static PaymentService getPaymentService() {
        return PaymentService.getInstance();
    }


}
