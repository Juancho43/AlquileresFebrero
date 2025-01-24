package Controller;

import java.io.Serializable;
import java.util.List;

public interface IBaseController<E extends Object, ID extends Serializable> {
    List<E> getAll();
    E create();
    E getById(ID id);
    E update(E e, ID id);
    boolean deleteById(ID id);

}
