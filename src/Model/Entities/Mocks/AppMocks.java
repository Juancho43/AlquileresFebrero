package Model.Entities.Mocks;

import Controller.ClientController;
import Controller.RentableObjects.ClothingController;
import Controller.RentableObjects.VehicleController;
import Controller.Rents.RentController;
import Model.Entities.Clients.Client;
import Model.Entities.RentableObjects.Clothing;
import Model.Entities.RentableObjects.Vehicle;
import Model.Factory.RentClothingFactory;
import Model.Factory.RentVehicleFactory;


import java.time.LocalDate;
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
        RentController rentController = new RentController();


        //Obtengo los objetos.
        List<Client> clients = clientController.getDao().getAll();
        List<Vehicle> vehicleList = v.getDao().getAll();
        List<Clothing> clothingList = c.getDao().getAll();

        //Make rent mocks

        rentController.setRentFactory(new RentVehicleFactory());
        rentController.newRent(2,vehicleList.get(1),clients.get(0));
        rentController.newRent(3,vehicleList.get(2),clients.get(1));
        rentController.setRentFactory(new RentClothingFactory());
        rentController.newRent(3, clothingList.get(0),clients.get(3));
        rentController.newRent(3, clothingList.get(2),clients.get(2));


        rentController.getDao().getAll().get(0).closeRent(LocalDate.now().plusDays(2));
        rentController.getDao().getAll().get(1).closeRent(LocalDate.now().plusDays(6));
        rentController.getDao().getAll().get(2).closeRent(LocalDate.now().plusDays(10));
//        rentController.getDao().getAll().get(0).getRent().closeRent(LocalDate.now().plusDays(2));
//        rentController.getDao().getAll().get(1).getRent().closeRent(LocalDate.now().plusDays(6));
//        rentController.getDao().getAll().get(2).getRent().closeRent(LocalDate.now().plusDays(10));
//        System.out.println(rentController.getDao().getAll().get(0).getDescription());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().calculateFirstDuration());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().calculateDuration());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().calculateDelayDays());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().checkStatus());
//        System.out.println("Ganancia: " + rentController.getDao().getAll().get(0).getEarning());
//        for (IRentable renta: rentController.getDao().getAll()) {
//            System.out.println(renta.getDescription());
//        }

    }

    public static void test(){
        add();
        data();
    }

}
