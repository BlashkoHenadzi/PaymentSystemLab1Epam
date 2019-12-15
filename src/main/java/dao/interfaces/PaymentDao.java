package dao.interfaces;

import beans.Account;
import beans.Payment;
import beans.User;

import java.util.List;

public interface PaymentDao extends GenericDao<Payment, Integer> {

    List<Payment> findByAccount(Account account);

    List<Payment> findByUser(User user);

}
