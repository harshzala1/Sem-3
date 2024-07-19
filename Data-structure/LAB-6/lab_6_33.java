import java.util.Scanner;
public class lab_6_33{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        
        Swap_no s =new Swap_no();


        System.out.print("enter value of a :");
        a = sc.nextInt();

        System.out.print("enter value of b :");
        b = sc.nextInt();

        s.swapping(a, b);


    }
}


class Swap_no{
    static  void swapping(int c,int d){
        c= c+d;
        d=c-d;
        c=c-d;
        System.out.println("a is "+c);
        System.out.println("b is "+d);  
        }
    }