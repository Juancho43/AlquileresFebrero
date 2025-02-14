package View.Utils;

import View.*;
import View.Clients.ClientTypeView;
import View.Clients.ClientView;
import View.RentableObject.ClothingView;
import View.RentableObject.VehicleView;

public class NavigationView {
    public static void openMenuView(){
        MenuView view = new MenuView();
    }
    public static void openClothingView(){
        ClothingView view = new ClothingView();
    }
    public static void openVehicleView(){
        VehicleView view = new VehicleView();
    }
    public static void openClientView(){
        ClientView view = new ClientView();
    }
    public static void openRentableObjectView(){
        RentableObjectView view = new RentableObjectView();
    }
    public static void openAboutView(){
        AboutView view = new AboutView();
    }
    public static void openRentView(){
        RentView view = new RentView();
    }
    public static void openHistoricalRentView(){
        HistoricalRentView view = new HistoricalRentView();
    }
    public static void openClientTypeView(){
        ClientTypeView view = new ClientTypeView();
    }


}
