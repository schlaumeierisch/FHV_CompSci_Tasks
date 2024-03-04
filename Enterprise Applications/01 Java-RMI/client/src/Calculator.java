import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    int calculateSquare(int x) throws RemoteException;

}
