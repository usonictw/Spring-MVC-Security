package dao;

import java.util.List;

public interface DAO<T> {

    void add(T t);
    T get(int id);
    void update(T t, int id);
    void delete(int id);
    List<T> getAll();
}
