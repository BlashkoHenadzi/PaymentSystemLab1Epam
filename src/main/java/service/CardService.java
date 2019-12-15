package service;
import beans.Account;
import beans.Card;
import beans.User;
import dao.factory.DaoFactory;
import dao.factory.connection.DaoConnection;
import dao.interfaces.CardDao;

import java.util.List;
import java.util.Optional;


public class CardService {
    private final DaoFactory daoFactory= DaoFactory.getInstance();

    private CardService() {}

    private static class Singleton {
        private final static CardService INSTANCE = new CardService();
    }

    public static CardService getInstance() {
        return Singleton.INSTANCE;
    }

    public Card createCard(Card card) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.insert(card);
        }
    }

    public List<Card> findAllCards() {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findAll();
        }
    }

    public Optional<Card> findCardByNumber(long cardNumber) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findOne(cardNumber);
        }
    }

    public List<Card> findAllByUser(User user) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findByUser(user);
        }
    }

    public List<Card> findAllByAccount(Account account) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findByAccount(account);
        }
    }


}
