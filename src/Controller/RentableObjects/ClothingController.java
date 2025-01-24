package Controller.RentableObjects;

import Model.Entities.RentableObjects.Clothing;

public class ClothingController extends RentableObjectController {

    public void newCloth(String name, String description, Double price, String size, String color) {
        getDao().save(new Clothing(name,description,price,size,color));
    }

}
