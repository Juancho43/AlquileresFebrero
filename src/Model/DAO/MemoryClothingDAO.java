package Model.DAO;

import Model.Exceptions.Exceptions;
import Model.Entities.RentableObjects.Clothing;

import java.util.ArrayList;
import java.util.List;

public class MemoryClothingDAO implements DAO<Clothing>{

    private final List<Clothing> clothingList = new ArrayList<>();

    private static MemoryClothingDAO memoryClothingDAO;
    public static MemoryClothingDAO getInstance(){
        if(memoryClothingDAO == null){
            memoryClothingDAO = new MemoryClothingDAO();
        }
        return memoryClothingDAO;
    }

    @Override
    public List<Clothing> getAll() {
        return clothingList;
    }

    @Override
    public Clothing getById(long id) {
        Clothing clothing = null;
        try{
            for (Clothing obj : clothingList) {
                if (obj.getId() == id) {
                    clothing = obj;
                }
            }
        } catch (Exception e) {
            new Exceptions.ObjectNotFoundException("ID de Ropa no encontrado " + id );
        }
        return clothing;
    }

    @Override
    public Clothing save(Clothing clothing) {
        clothingList.add(clothing);
        return clothing;
    }

    @Override
    public Clothing updateById(long id, Clothing clothing) {
        getById(id).setColor(clothing.getColor());
        getById(id).setSize(clothing.getSize());
        getById(id).setObject(clothing.getObject());
        return getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return clothingList.removeIf(obj -> obj.getId() == id);
    }
}
