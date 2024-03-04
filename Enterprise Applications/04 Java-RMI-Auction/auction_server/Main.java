import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      try {
         LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

         List<Item> items = new LinkedList<>();
         items.add(new Item("i1", 10));
         items.add(new Item("i2", 20));
         items.add(new Item("i3", 30));

         Auction auction = new AuctionImpl(items);
         Naming.rebind("rmi://localhost/Auction", auction);

         System.out.println("Auction bound in registry");
         System.out.println("Clients on start " + auction.getClients());
         System.out.println("Itemlist on start " + items);

      } catch (Exception e) {
         System.out.println("Auction err: " + e.getMessage());
         e.printStackTrace();
      }
   }
}