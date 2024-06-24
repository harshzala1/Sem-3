import java.util.Scanner;
public class Q30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        System.out.println("Enter row:");
        int n=sc.nextInt();
        System.out.println("Enter col:");
        int m=sc.nextInt();
        int[][] mat1 = new int[n][m];
        int[][] mat2 = new int[n][m];
        int[][] mat3 = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("Enter the element of frist matrix ["+i+"] and ["+j+"]");
                mat1[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
               System.out.print( mat1[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("Enter the element of second matrix ["+i+"] and ["+j+"]");
                mat2[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               System.out.print( mat2[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat3[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        System.out.println("here is the ans");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              
                System.out.print(mat3[i][j]+" ");
            }
            System.out.println();
        }
    }
}
