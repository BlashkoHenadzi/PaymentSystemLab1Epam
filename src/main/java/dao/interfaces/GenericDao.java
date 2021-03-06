package dao.interfaces;
import java.util.List;
import java.util.Optional;

public interface GenericDao <T, ID>{

    Optional<T> findOne(ID id);

    List<T> findAll();

    T insert(T obj);

    void update(T obj);

    void delete(ID id);

    default boolean exist(ID id) {
        return findOne(id).isPresent();
    }

}
