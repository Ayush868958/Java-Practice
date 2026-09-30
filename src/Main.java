
public class Main{
    public static void main(String[]args) {
     int a,b;
     a=10;
     b=20;
     calculator s1=new calculator(a,b);
     s1.add();
     s1.subtract();
     s1.multiply();


     // bankaccount wala part

        String name="Raj";
        int acc_number=12345;
        int balance=1000;
        int amount=200;
        Bank_account re=new Bank_account(name,acc_number,balance);
        re.deposit(amount);
        re.withdraw(amount);
        re.check_balance();
    }
};