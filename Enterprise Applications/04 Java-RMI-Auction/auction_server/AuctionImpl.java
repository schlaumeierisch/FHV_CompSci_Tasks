import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class AuctionImpl extends UnicastRemoteObject implements Auction {

   private List<Item> items;
   private List<Client> clients;

   protected AuctionImpl(List<Item> items) throws RemoteException {
      this.items = items;
      this.clients = new LinkedList<>();
   }

   @Override
   public List<Item> join(Client client) throws RemoteException {
      clients.add(client);
      System.out.println("Client added: " + client.getName());

      return this.items;
   }

   @Override
   public void leave(Client client) throws RemoteException {
      clients.remove(client);
      System.out.println("Client removed: " + client.getName());
   }

   @Override
   public boolean bid(Client client, Item item, int price) throws RemoteException {

      for (int i = 0; i < items.size(); i++) {
         if (items.get(i).getName().equals(item.getName())) {
            if (price > items.get(i).getPrice()) {
               items.get(i).setPrice(price);
               System.out
                     .println("Price from item " + items.get(i).getName() + " changed to " + items.get(i).getPrice());
               break;
            } else {
               return false;
            }
         }
      }

      for (int i = 0; i < clients.size(); i++) {
         client.update(item, price);
         System.out.println("Client updated: " + client.getName());
      }

      return true;
   }

   @Override
   public List<Client> getClients() throws RemoteException {
      return clients;
   }

}