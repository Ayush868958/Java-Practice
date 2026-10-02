import bank.Account;
import bank.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account a1 = new SavingsAccount(101, "Ayush", 5000);

        a1.deposit(1000);

        a1.withdraw(3000);

        a1.withdraw(2500);
    }
}