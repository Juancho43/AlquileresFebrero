package Model.DAO;

import Model.Entities.Rents.IRentable;

import java.util.ArrayList;
import java.util.List;

public class MemoryRentDAO implements DAO<IRentable>{

    private List<IRentable> objectRents = new ArrayList<>();

    private static MemoryRentDAO RentDAO;
    public static MemoryRentDAO getInstance(){
        if(RentDAO == null){
            RentDAO = new MemoryRentDAO();
        }
        return RentDAO;
    }





    @Override
    public List<IRentable> getAll() {
        return objectRents;
    }

    @Override
    public IRentable getById(long id) {
        IRentable rentableObject = null;
        try{
            for (IRentable obj : objectRents) {
                if (obj.getId() == id) {
                    rentableObject = obj;
                }
            }
        } catch (Exception e) {
            System.out.println("Id no encontrado" + e);
        }
        return rentableObject;
    }

    @Override
    public IRentable save(IRentable object) {
        objectRents.add(object);
        return object;
    }

    @Override
    public IRentable updateById(long id, IRentable object) {
        getById(id).setRentableObject(object.getRentableObject());
        getById(id).setClient(object.getClient());
        getById(id).setPriceMethod(object.getMethod());
        return getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return objectRents.removeIf(obj -> obj.getId() == id);
    }

}
