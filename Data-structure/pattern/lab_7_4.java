import  java.util.*;
public class lab_7_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the row ");
        int n = sc.nextInt();
        int m =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                
                System.out.print(" ");  
            }
            for(int k=1;k<=i;k++ ){
                if(m%2==0){
                    System.out.print("1"); 
                    m++;
                } else{
                    System.out.print("*"); 
                    m++;
                }
            }
            System.out.println(" ");
            m=0; 
        }
    
    }
}
