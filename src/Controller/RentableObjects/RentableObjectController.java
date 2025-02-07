package Controller.RentableObjects;

import DAO.MemoryRentableObjectDAO;

public abstract class RentableObjectController{

    private  MemoryRentableObjectDAO dao = MemoryRentableObjectDAO.getInstance();


    public RentableObjectController() {
    }

    public MemoryRentableObjectDAO getDao() {
        return dao;
    }


}
