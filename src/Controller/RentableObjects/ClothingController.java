package Controller.RentableObjects;

import DAO.DAO;
import DAO.MemoryClothingDAO;
import Model.Entities.RentableObjects.Clothing;

import java.util.List;

public class ClothingController {
    private final DAO<Clothing> dao = MemoryClothingDAO.getInstance();

    public void newCloth(String name, String description, Double price, String size, String color) {
        getDao().save(new Clothing(name,description,price,size,color));
    }

    public List<Clothing> getAllClothies() {
        return dao.getAll();
    }

    public Clothing getClothinById(long id) {
        return dao.getById(id);
    }

    public Clothing updateCloth(long id, Clothing updatedCloth) {
        return dao.updateById(id, updatedCloth);
    }

    public boolean deleteCloth(long id) {
        return dao.deleteById(id);
    }

    public DAO<Clothing> getDao() {
        return dao;
    }

}
