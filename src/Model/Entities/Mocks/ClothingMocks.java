package Model.Entities.Mocks;
import Controller.RentableObjects.ClothingController;
public class ClothingMocks {

    private static final ClothingController clothingController = new ClothingController();
    public static void add(){
        clothingController.newCloth("Disfraz de barni","Version original",1.2,"xl","rosa");
        clothingController.newCloth("Disfraz de spiderman","Version original",2.2,"xl","rojo");
        clothingController.newCloth("Disfraz de superman","Version original",3.2,"xl","rojo");
        clothingController.newCloth("Disfraz de pepaPig","Version original",4.2,"xl","rosa");
    }

}
