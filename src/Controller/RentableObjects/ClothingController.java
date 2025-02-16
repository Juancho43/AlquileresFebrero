package Controller.RentableObjects;

import Controller.IControllable;
import Controller.IFactory;
import Model.DAO.DAO;
import Model.DAO.MemoryClothingDAO;
import Model.Entities.RentableObjects.Clothing;
import Model.Factory.RentClothingFactory;
import Model.Factory.RentFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ClothingController implements IControllable, IFactory {
    private final DAO<Clothing> dao = MemoryClothingDAO.getInstance();

    public void newCloth(String name, String description, Double price, String size, String color) {
        getDao().save(new Clothing(name,description,price,size,color));
    }
    public List<Clothing> getAllAvaliableCloth(){
        return  getDao().getAll().stream().filter(cloth -> cloth.getObject().isAvailable()).collect(Collectors.toList());
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

    @Override
    public RentFactory getFactory() {
        return new RentClothingFactory();
    }

    @Override
    public String toString() {
        return "Ropa";
    }
}
