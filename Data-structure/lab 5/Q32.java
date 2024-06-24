import java.util.Random;
import java.util.Scanner;
public class Q32 {
 public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    System.out.println("Enter n");
    int n=sc.nextInt();
    String[] name = new String[n];
    for(int i=0;i<n;i++){
        name[i] = sc.next();
    }
    for(int i=0;i<n;i++){
        System.out.print(name[i]+",");
    }
    Random r = new Random();
    int randomidx=r.nextInt(n);
    System.out.println("Random no:"+randomidx);

    
        System.out.print(name[randomidx]);
    


   


 }   
}