import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Client extends Remote {

   void update(Item item, int price) throws RemoteException;

   List<Item> getItems() throws RemoteException;

   void setItems(List<Item> items) throws RemoteException;

   String getName() throws RemoteException;

}