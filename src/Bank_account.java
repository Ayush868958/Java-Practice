public class Bank_account {
    String account_holder;
    int acc_number;
    int balance;
    Bank_account(String ah,int an,int b){
        account_holder=ah;
        acc_number=an;
        balance=b;
    }
    void deposit(int amount){
        int current_balance=balance+amount;
        System.out.println("You deposited amount is"+current_balance);
    }
    void withdraw(int amount){
        int current=balance-amount;
        System.out.println("Your amount after withdraw"+current);
    }
    void check_balance(){
        System.out.println("Your current balance is:"+balance);

    }

};
