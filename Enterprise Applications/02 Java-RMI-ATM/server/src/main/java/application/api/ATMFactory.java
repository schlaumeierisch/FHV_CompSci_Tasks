package application.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ATMFactory extends Remote {
    ATM create() throws RemoteException;
}
