import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServant extends UnicastRemoteObject implements Calculator {

    protected CalculatorServant() throws RemoteException {
        super();
    }

    public int calculateSquare(int x) {
        return x * x;
    }

}
