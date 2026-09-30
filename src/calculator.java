public class calculator {
    int a,b;
    calculator(int a,int b){
        this.a=a;
        this.b=b;
    }
    void add(){
        int sum=a+b;
        System.out.println("Sum is"+sum);
    }
    void subtract(){
        int sub=a-b;
        System.out.println("Subtract is"+sub);
    }
    void multiply(){
        int m=a*b;
        System.out.println("Multiply is"+m);
    }

};
