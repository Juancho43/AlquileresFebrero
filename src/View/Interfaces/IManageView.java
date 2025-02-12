package View.Interfaces;

public interface IManageView<D extends Object>{

    void setCurrentData();
    D selectItem();
    void cleanFields();
    void updateList();
    void createItem();
    void editItem();
    void deleteItem(long id);
}
