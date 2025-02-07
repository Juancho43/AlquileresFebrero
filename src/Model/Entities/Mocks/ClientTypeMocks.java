package Model.Entities.Mocks;


import Controller.ClientTypeController;
public class ClientTypeMocks {
    private static final ClientTypeController clientTypeController = new ClientTypeController();

    public static void add(){
        clientTypeController.newType("Common",0.03);
        clientTypeController.newType("VIP",0.3);
    }
}

