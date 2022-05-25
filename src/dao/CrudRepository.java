package dao;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {
    T save(T entity);
    T findOne(ID primaryKey);
    List<T> findAll();
    Integer count();
    void delete(ID primaryKey);
    boolean exists(ID primaryKey);
}
