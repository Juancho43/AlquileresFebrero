package View.Utils;

import View.*;
import View.Clients.ClientView;
import View.RentableObject.ClothingView;
import View.RentableObject.VehicleView;

public class NavigationView {
    public static void openMenuView(){
        MenuView menuView = new MenuView();
    }
    public static void openClothingView(){
        ClothingView clothingView = new ClothingView();
    }
    public static void openVehicleView(){
        VehicleView vehicleView = new VehicleView();
    }
    public static void openClientView(){
        ClientView clientView = new ClientView();
    }
    public static void openRentableObjectView(){
        RentableObjectView rentableObjectView = new RentableObjectView();
    }
    public static void openAboutView(){
        AboutView aboutView = new AboutView();
    }
    public static void openRentView(){
        RentView rentView = new RentView();
    }
    public static void openHistoricalRentView(){
        HistoricalRentView rentView = new HistoricalRentView();
    }

}
