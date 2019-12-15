package dao.interfaces;

import beans.Account;
import beans.User;
import java.math.BigDecimal;
import java.util.List;

public interface AccountDao extends GenericDao<Account, Long> {

    List<Account> findByUser(User user);

    List<Account> findByStatus(Account.Status status);

    void increaseBalance(Account account, BigDecimal amount);

    void decreaseBalance(Account account, BigDecimal amount);

    void updateAccountStatus(Account account, Account.Status status);

}
