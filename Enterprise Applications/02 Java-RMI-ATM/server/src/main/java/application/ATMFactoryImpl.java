package application;

import application.api.ATM;
import application.api.ATMFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ATMFactoryImpl extends UnicastRemoteObject implements ATMFactory {

    public ATM create() throws RemoteException {
        return new ATM();
    }

}
