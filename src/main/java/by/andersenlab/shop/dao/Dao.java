package by.andersenlab.shop.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> getById(long id);
    List<T> getAll();
    boolean save(T t);
    void deleteById(long id);
}
