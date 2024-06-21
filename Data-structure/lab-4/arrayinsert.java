import java.util.Scanner;

public class arrayinsert {
    public static void main(String[] args) {
        int [] a =arraydelete.inputarray();
        System.out.println("enter the element that you want to add");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("enter the element location");
        int l= sc.nextInt();
   
       
        int [] b = insert(a, n,l);  
        arraydelete.arrayprint(b);

     

    }
    public static int[] insert(int [] a,int n ,int l){
        int [] c = new int[a.length+1];
        for(int i =0;i<a.length+1;i++){
            if(i<l){
                c[i]=a[i];
                
            }else if(i==l){
                c[i]=n;
            }else{
                c[i]=a[i-1];
            }
        }
        return c;
    }
} 
