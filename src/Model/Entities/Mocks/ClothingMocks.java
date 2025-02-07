package Model.Entities.Mocks;
import Controller.RentableObjects.ClothingController;
public class ClothingMocks {

    private static final ClothingController c = new ClothingController();
    public static void add(){
        c.newCloth("Disfraz de barni","Version original",1.2,"xl","rosa");
        c.newCloth("Disfraz de spiderman","Version original",2.2,"xl","rojo");
        c.newCloth("Disfraz de superman","Version original",3.2,"xl","rojo");
        c.newCloth("Disfraz de pepaPig","Version original",4.2,"xl","rosa");
    }

}
