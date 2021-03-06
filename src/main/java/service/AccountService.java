package service;
import beans.Account;
import beans.User;
import dao.factory.DaoFactory;
import dao.factory.connection.DaoConnection;
import dao.interfaces.AccountDao;

import java.util.List;
import java.util.Optional;


public class AccountService {
    private final DaoFactory daoFactory= DaoFactory.getInstance();

    private AccountService() {}

    private static class Singleton {
        private final static AccountService INSTANCE = new AccountService();
    }

    public static AccountService getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Account> findAllAccounts() {
        try(DaoConnection connection = daoFactory.getConnection()) {
            AccountDao accountDao = daoFactory.getAccountDao(connection);
            return accountDao.findAll();
        }
    }

    public Optional<Account> findAccountByNumber(long accountNumber) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            AccountDao accountDao = daoFactory.getAccountDao(connection);
            return accountDao.findOne(accountNumber);
        }
    }

    public List<Account> findAllByUser(User user) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            AccountDao accountDao = daoFactory.getAccountDao(connection);
            return accountDao.findByUser(user);
        }
    }

    public List<Account> findAllByStatus(Account.Status status) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            AccountDao accountDao = daoFactory.getAccountDao(connection);
            return accountDao.findByStatus(status);
        }
    }

    public Account createAccount(Account account) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            AccountDao accountDao = daoFactory.getAccountDao(connection);
            Account inserted = accountDao.insert(account);
            return inserted;
        }
    }

    public void updateAccountStatus(Account account, Account.Status status) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            connection.startSerializableTransaction();
            AccountDao accountDao = daoFactory.getAccountDao(connection);
            accountDao.updateAccountStatus(account, status);
            connection.commit();
        }
    }

}
