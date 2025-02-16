package Model.Entities.Mocks;

import Controller.ClientTypeController;

/**
 * Provides mock client type data for testing and demonstration purposes.
 * This class uses the `ClientTypeController` to create predefined `ClientType`
 * objects with various attributes (type name and discount). These mock client
 * types can be used to populate the application with sample data for testing
 * or demonstration purposes.
 */
public class ClientTypeMocks {

    private static final ClientTypeController clientTypeController = new ClientTypeController(); // Controller for managing client types.

    /**
     * Adds a set of mock client types to the system.
     * This method creates two sample `ClientType` objects ("Common" and "VIP")
     * with different discount rates and persists them using the
     * `ClientTypeController`. These mock client types can then be used when
     * creating mock clients or for other testing scenarios.
     */
    public static void add() {
        clientTypeController.newType("Common", 0.03); // Create a "Common" client type with a 3% discount.
        clientTypeController.newType("VIP", 0.3);    // Create a "VIP" client type with a 30% discount.
    }
}