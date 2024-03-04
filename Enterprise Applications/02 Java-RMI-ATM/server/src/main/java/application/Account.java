package application;

public class Account {

    private String iban;
    private double balance;

    public Account(String iban) {
        this.iban = iban;
        this.balance = 0;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance(){
        return balance;
    }

}
