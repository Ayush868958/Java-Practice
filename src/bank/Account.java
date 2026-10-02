package bank;

public class Account {
    int accountNumber;
    String name;
    int balance;
    public Account (int accountNumber,String name,int balance){
        this.accountNumber=accountNumber;
        this.name=name;
        this.balance=balance;
    }
    public void deposit(int amount){
        balance=balance+amount;
        System.out.println("Current balance is"+balance);
    }
    public void withdraw(int amount){
        balance=balance-amount;

System.out.println("Current balance is"+balance);
    }
    public int getBalance() {
        return balance;
    }
}
