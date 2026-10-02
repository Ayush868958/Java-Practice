package bank;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String name, int balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public void withdraw(int amount) {

        if (getBalance() - amount >= 1000) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal not allowed!");
            System.out.println("Minimum balance of ₹1000 is required.");
        }
    }
}
