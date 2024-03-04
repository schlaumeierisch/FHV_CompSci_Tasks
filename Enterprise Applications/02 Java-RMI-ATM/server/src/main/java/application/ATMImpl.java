package application;

import application.api.ATM;

import java.rmi.RemoteException;

public class ATMImpl implements ATM {

    public void deposit(int accountNo, float amount) throws RemoteException {

    }

    public void withdraw(int accountNo, float amount) throws RemoteException {

    }

    public float getBalance(int accountNo) throws RemoteException {
        return 0;
    }
}
