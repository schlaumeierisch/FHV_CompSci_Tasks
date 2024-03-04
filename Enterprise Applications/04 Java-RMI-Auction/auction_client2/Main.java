import java.rmi.Naming;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) throws Exception {

      Scanner input = new Scanner(System.in);

      System.out.println("Type 'start' to enter auction");

      if (input.nextLine().equals("start")) {
         System.out.println("Enter your name: ");

         Auction auction = (Auction) Naming.lookup("rmi://localhost/Auction");
         Client client = new ClientImpl(input.nextLine(), auction);
         client.setItems(auction.join(client));

         System.out.println("Successfully joined auction");
         System.out.println("Commands: 'items' to get item list, 'bid' to bid on item, 'exit' to leave auction");
         boolean leave = false;

         while (leave == false) {

            String inputValue = input.nextLine();

            if (inputValue.equals("exit")) {
               auction.leave(client);
               System.out.println("Successfully left auction");
               leave = true;
            } else if (inputValue.equals("items")) {
               System.out.println("Item list: " + client.getItems());
            } else if (inputValue.equals("bid")) {
               System.out.println("Enter item name you want to bid on: ");
               inputValue = input.nextLine();
               boolean itemFound = false;

               for (int i = 0; i < client.getItems().size(); i++) {
                  if (inputValue.equals(client.getItems().get(i).getName())) {
                     System.out.println("Enter the amount you want to bid: ");
                     inputValue = input.nextLine();
                     itemFound = true;

                     if (auction.bid(client, client.getItems().get(i), Integer.parseInt(inputValue))) {
                        System.out.println("Successfully bid on item " + client.getItems().get(i).getName()
                              + " (new price: " + client.getItems().get(i).getPrice() + ")");
                        break;
                     } else {
                        System.out.println("Bidding failed (price offered must be higher than item's current price)");
                        break;
                     }
                  }
               }

               if (!itemFound) {
                  System.out.println("Bidding failed (item not found)");
               }
            } else if (inputValue.equals("commands")) {
               System.out.println("Commands: 'items' to get item list, 'bid' to bid on item, 'exit' to leave auction");
            } else {
               System.out.println("Unknown command. Type 'commands' to see all available commands");
            }
         }
      }

      input.close();
   }
}