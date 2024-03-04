import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Auction extends Remote {

   List<Item> join(Client client) throws RemoteException;

   void leave(Client client) throws RemoteException;

   boolean bid(Client client, Item item, int price) throws RemoteException;

   List<Client> getClients() throws RemoteException;

}