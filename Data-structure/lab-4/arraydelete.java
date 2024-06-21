import java.util.Scanner;

public class arraydelete {
  
    public static void main(String args[]){
        int [] a = inputarray();
        System.out.println("enter the element that you want to deleat");
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int [] b=dealitarray(a, n);
        System.out.println("here is your edited array");
        arrayprint(b);
    }
    public static int[] inputarray(){
        Scanner input=new Scanner(System.in);
        System.out.println("pleasae enter the size of array");
        int size = input.nextInt();
        int [] a = new int [size];
        for(int i=0;i<size;i++){
            System.out.println("enter the element number"+i);
            a[i]=input.nextInt();

        }
         return a;
    }
    public static void arrayprint(int [] b){
        for(int i=0;i<b.length;i++){
            System.out.println("here is your"+i+ "element " +b[i]);
        }

    }
    public static int[] dealitarray(int[] b,int n){
       
        int occ = occur(b,n);
        if(occ==0){
            return b;
       }
       else{
        int j=0;
        int arraysize=b.length-occ;
        int [] newarray = new int[arraysize];
        for(int i=0;i<b.length;i++){
            if(n!=b[i]){
                newarray[j]=b[i];
                j++;
            }
        }
        return newarray;
       }
       
      }
      public static int occur(int [] b,int n){
        int occ=0;
        for(int i=0;i<b.length;i++){
            if(b[i]==n){
                occ++;
            }
     }
        return occ;
    }
}

