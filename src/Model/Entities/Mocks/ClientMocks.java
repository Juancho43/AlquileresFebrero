package Model.Entities.Mocks;


import Controller.ClientController;
import Model.Enums.ClientTypes;
import Model.Strategy.Cash;
import Model.Strategy.CreditCard;

public class ClientMocks {
    private static ClientController c = new ClientController();
    public static void add(){
        c.newClient("Juan","juan@juan.com","43592888", ClientTypes.COMMON,new Cash());
        c.newClient("Nico","nico@juan.com","22233111", ClientTypes.VIP,new CreditCard());
        c.newClient("Andres","andres@juan.com","22333111", ClientTypes.COMMON,new CreditCard());
        c.newClient("Mauro","mauro@juan.com","66333222", ClientTypes.VIP,new Cash());
    }
}
