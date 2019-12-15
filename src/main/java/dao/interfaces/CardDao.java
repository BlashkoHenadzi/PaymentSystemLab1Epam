package dao.interfaces;
import beans.Account;
import beans.Card;
import beans.User;

import java.util.List;

public interface CardDao extends GenericDao<Card, Long> {

    List<Card> findByUser(User user);

    List<Card> findByAccount(Account account);
}
