package DAO;

import Model.Entities.ClientType;
import java.util.ArrayList;
import java.util.List;


public class MemoryClientTypeDAO implements DAO<ClientType>{

    private final List<ClientType> typeList = new ArrayList<>();

    private static MemoryClientTypeDAO ClientMemoryDao;
    public static MemoryClientTypeDAO getInstance(){
        if(ClientMemoryDao == null){
            ClientMemoryDao = new MemoryClientTypeDAO();
        }
        return ClientMemoryDao;
    }

    @Override
    public List<ClientType> getAll() {
        return typeList;
    }

    @Override
    public ClientType getById(long id) {
        ClientType type = null;
        try{
            for (ClientType obj : typeList) {
                if (obj.getId() == id) {
                    type = obj;
                }
            }
        } catch (Exception e) {
            System.out.println("Id no encontrado" + e);
        }
        return type;
    }

    @Override
    public ClientType save(ClientType type) {
        typeList.add(type);
        return type;
    }

    @Override
    public ClientType updateById(long id, ClientType type) {
        getById(id).setDiscount(type.getDiscount());
        getById(id).setType(type.getType());

        return getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return typeList.removeIf(obj -> obj.getId() == id);
    }

}
