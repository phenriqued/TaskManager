package phenrique.com.github.DAO;

import java.util.List;

public interface DAO<T> {

    void save(T object);
    void remove(T objectId);
    T update(Long id, T object);
    T findById(Long id);
    List<T> toListAll();
}
