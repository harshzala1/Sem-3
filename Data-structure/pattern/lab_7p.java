import  java.util.*;
public class lab_7p {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the row ");
        int n = sc.nextInt();
        char c='A';
        int m= 1;
        for(int i=1;i<=n;i++ ){
                if(i%2==0){
                    for(int j =1;j<=i;j++){
                        System.out.print(c+" ");
                        c++;  
                    }
                    
                    System.out.println(""); 
                }else{
                    for(int j =1;j<=i;j++){
                        System.out.print(m+" ");
                        m++;
                        
                    }
                    System.out.println(""); 
                }
        }
    }
}
