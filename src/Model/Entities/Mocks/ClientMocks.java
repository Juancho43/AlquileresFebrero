package Model.Entities.Mocks;


import Controller.ClientController;
import Controller.ClientTypeController;
import Model.Strategy.Cash;
import Model.Strategy.CreditCard;

public class ClientMocks {
    private static final ClientController clientController = new ClientController();
    private static final ClientTypeController clientTypeController = new ClientTypeController();


    public static void add(){
        clientController.newClient("Juan","juan@juan.com","43592888", clientTypeController.getDao().getAll().get(0),new Cash());
        clientController.newClient("Nico","nico@juan.com","22233111",   clientTypeController.getDao().getAll().get(1),new CreditCard());
        clientController.newClient("Andres","andres@juan.com","22333112",   clientTypeController.getDao().getAll().get(0),new CreditCard());
        clientController.newClient("Mauro","mauro@juan.com","66333222",   clientTypeController.getDao().getAll().get(1),new Cash());

    }
}
