package DAO;

import Model.Entities.Clients.Client;

import java.util.ArrayList;
import java.util.List;



public class MemoryClientDAO implements DAO<Client>{

    private final List<Client> clientList = new ArrayList<>();

    private static MemoryClientDAO ClientMemoryDao;
    public static MemoryClientDAO getInstance(){
        if(ClientMemoryDao == null){
            ClientMemoryDao = new MemoryClientDAO();
        }
        return ClientMemoryDao;
    }

    @Override
    public List<Client> getAll() {
        return clientList;
    }

    @Override
    public Client getById(long id) {
        Client client = null;
        try{
            for (Client obj : clientList) {
                if (obj.getId() == id) {
                    client = obj;
                }
            }
        } catch (Exception e) {
            System.out.println("Id no encontrado" + e);
        }
        return client;
    }

    @Override
    public Client save(Client client) {
        clientList.add(client);
        return client;
    }

    @Override
    public Client updateById(long id, Client client) {
        getById(id).setName(client.getName());
        getById(id).setEmail(client.getEmail());
        getById(id).setDni(client.getDni());
        getById(id).setClientTypeId(client.getType());
        getById(id).setPaymentMethod(client.getPaymentMethod());
        return getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return clientList.removeIf(obj -> obj.getId() == id);
    }

}
