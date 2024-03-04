import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ClientImpl extends UnicastRemoteObject implements Client {

   private String name;
   private Auction auction;
   private List<Item> items;

   protected ClientImpl(String name, Auction auction) throws RemoteException {
      this.name = name;
      this.auction = auction;
   }

   @Override
   public void update(Item item, int price) throws RemoteException {

      for (int i = 0; i < items.size(); i++) {
         if (items.get(i).getName().equals(item.getName())) {
            items.get(i).setPrice(price);
         }
      }

      System.out.println("Updated item: " + item.getName());
   }

   @Override
   public List<Item> getItems() throws RemoteException {
      return items;
   }

   @Override
   public void setItems(List<Item> items) throws RemoteException {
      this.items = items;
   }

   @Override
   public String getName() throws RemoteException {
      return this.name;
   }

}
