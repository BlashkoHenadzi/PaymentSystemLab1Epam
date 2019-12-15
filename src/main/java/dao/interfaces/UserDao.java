package dao.interfaces;
import beans.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User, Integer>{

    Optional<User> findOneByEmail(String email);

    boolean existByEmail(String email);
}
