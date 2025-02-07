package Controller.RentableObjects;

import DAO.DAO;
import DAO.MemoryClothingDAO;
import Model.Entities.RentableObjects.Clothing;

public class ClothingController {
    private final DAO dao = MemoryClothingDAO.getInstance();

    public DAO getDao() {
        return dao;
    }
    public void newCloth(String name, String description, Double price, String size, String color) {
        getDao().save(new Clothing(name,description,price,size,color));
    }

}
