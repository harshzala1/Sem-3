import java.util.Scanner;

public class Lab_4_1 {
    public static void main(String[] args) {
        int [] a =arraydelete.inputarray();

        System.out.println("enter the element that you want to add");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] b = sortadd(a, n);  
        arraydelete.arrayprint(b);
    }
    public static int[] sortadd(int [] a,int n ){
        int [] c = new int[a.length+1];
        int temp = 0;
        for(int i =0;i<a.length+1;i++){
            if(a[i]>n){
               temp=i; 
            }
        }
        return c;
    }

}
