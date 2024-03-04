import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {

    public static void main(String[] args) {

        try {

            CalculatorServant obj = new CalculatorServant();

            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            Naming.rebind("rmi://localhost/CalculatorObject", obj);

            System.out.println("CalculatorObject bound in registry");

        } catch (Exception e) {
            System.out.println("CalculatorServant error: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
