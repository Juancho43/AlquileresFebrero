package DAO;
import Model.Entities.RentableObjects.RentableObject;

import java.util.ArrayList;
import java.util.List;

public class MemoryRentableObjectDAO implements DAO<RentableObject> {

    private List<RentableObject> rentableObjectList = new ArrayList<>();

    private static MemoryRentableObjectDAO RentableObjectMemoryDAO;
    public static MemoryRentableObjectDAO getInstance(){
        if(RentableObjectMemoryDAO == null){
            RentableObjectMemoryDAO = new MemoryRentableObjectDAO();
        }
        return RentableObjectMemoryDAO;
    }

    @Override
    public List<RentableObject> getAll() {
        return rentableObjectList;
    }

    public List<RentableObject> getAvalibleRentableObjectList(){
        List<RentableObject> rentableObjects = new ArrayList<>();
        for (RentableObject rentableObject : rentableObjectList){
            if (rentableObject.isAvalible()){
                rentableObjects.add(rentableObject);
            }
        }
        return  rentableObjects;
    }

    @Override
    public RentableObject getById(long id) {
        RentableObject rentableObject = null;
        try{
            for (RentableObject obj : rentableObjectList) {
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
    public RentableObject save(RentableObject object) {
        rentableObjectList.add(object);
        return object;
    }

    @Override
    public RentableObject updateById(long id, RentableObject object) {
        getById(id).setName(object.getName());
        getById(id).setDescription(object.getDescription());
        getById(id).setPricePerDay(object.getPricePerDay());
        getById(id).setAvalible(object.isAvalible());
        return getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return rentableObjectList.removeIf(obj -> obj.getId() == id);
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
