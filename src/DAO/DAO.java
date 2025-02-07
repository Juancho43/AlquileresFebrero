package DAO;

import java.util.List;

public interface DAO <E extends Object>{
    List<E> getAll();
    E getById(long id);

    E save(E object);

    E updateById(long id, E object);
    boolean deleteById(long id);



}
