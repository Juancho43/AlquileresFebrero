package DAO;

import Model.Entities.RentableObjects.RentableObject;
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
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return objectRents.removeIf(obj -> obj.getId() == id);
    }

    @Override
    public boolean exportData() {
        return false;
    }

    @Override
    public boolean importData() {
        return false;
    }
}
