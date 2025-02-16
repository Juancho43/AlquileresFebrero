package Model.Entities.Mocks;

import Controller.ClientController;
import Controller.ClientTypeController;
import Model.Strategy.Cash;
import Model.Strategy.CreditCard;

/**
 * Provides mock client data for testing and demonstration purposes.
 * This class uses the `ClientController` and `ClientTypeController` to create
 * predefined `Client` objects with various attributes (name, email, DNI, client type,
 * and payment method). These mock clients can be used to populate the application
 * with sample data for testing or demonstration purposes.
 */
public class ClientMocks {

    private static final ClientController clientController = new ClientController(); // Controller for managing clients.
    private static final ClientTypeController clientTypeController = new ClientTypeController(); // Controller for managing client types.

    /**
     * Adds a set of mock clients to the system.
     * This method creates four sample `Client` objects with different characteristics
     * and persists them using the `ClientController`.  It retrieves existing client
     * types from the `ClientTypeController` to assign to the mock clients.  It also
     * assigns different payment methods (Cash and CreditCard).
     */
    public static void add() {
        clientController.newClient("Juan", "juan@juan.com", "43592888", clientTypeController.getDao().getAll().get(0), new Cash());
        clientController.newClient("Nico", "nico@juan.com", "22233111", clientTypeController.getDao().getAll().get(1), new CreditCard());
        clientController.newClient("Andres", "andres@juan.com", "22333112", clientTypeController.getDao().getAll().get(0), new CreditCard());
        clientController.newClient("Mauro", "mauro@juan.com", "66333222", clientTypeController.getDao().getAll().get(1), new Cash());
    }
}