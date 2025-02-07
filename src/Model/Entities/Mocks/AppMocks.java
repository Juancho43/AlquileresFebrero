package Model.Entities.Mocks;

import Controller.ClientController;
import Controller.ClientTypeController;
import Controller.RentableObjects.ClothingController;
import Controller.RentableObjects.VehicleController;
import Model.Entities.Client;
import Model.Entities.ClientType;
import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.IRentable;
import Model.Factory.RentClothingFactory;
import Model.Factory.RentFactory;
import Model.Factory.RentVehicleFactory;
import Model.Strategy.Cash;
import Model.Strategy.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class AppMocks {

    public static void add(){
        VehicleMocks.add();
        ClothingMocks.add();
        ClientTypeMocks.add();
        ClientMocks.add();
    }

    public static void data(){
        //Controllers
        VehicleController v = new VehicleController();
        ClothingController c = new ClothingController();
        ClientController clientController = new ClientController();


        //Obtengo los objetos.
        List<Client> clients = clientController.getDao().getAll();


        List<RentableObject> objectList = v.getDao().getAll();
        objectList.addAll(c.getDao().getAll());



        //Factories
        List<RentFactory> factories = new ArrayList<>();
        factories.add(new RentVehicleFactory());
        factories.add(new RentClothingFactory());
        //Make rent mocks
        List<IRentable> rentas = new ArrayList<>();
        rentas.add(factories.get(0).rentObject(2,objectList.get(1),clients.get(0)));
        rentas.add(factories.get(0).rentObject(3,objectList.get(2),clients.get(1)));
        rentas.add(factories.get(1).rentObject(3, objectList.get(5),clients.get(3)));
        rentas.add(factories.get(1).rentObject(3, objectList.get(6),clients.get(2)));


//        rentas.get(0).getRent().closeRent(LocalDate.now().plusDays(2));
//        System.out.println(rentas.get(0).getDescription());
//        System.out.println(rentas.get(0).getRent().calculateFirstDuration());
//        System.out.println(rentas.get(0).getRent().calculateDuration());
//        System.out.println(rentas.get(0).getRent().calculateDelayDays());
//        System.out.println(rentas.get(0).getRent().checkStatus());
//        System.out.println("Ganancia: " + rentas.get(0).getEarning());


        for (IRentable renta: rentas) {
            System.out.println(renta.getDescription());
        }

    }

    public static void test(){
        add();
        data();
    }

}
