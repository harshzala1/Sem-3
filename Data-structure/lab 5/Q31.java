import java.util.Scanner;
public class Q31 {
    public static void main(String[] args) {
                Scanner sc = new Scanner((System.in));
                int[][] mat1 = new int[3][2];
        int[][] mat2 = new int[2][3];
        int[][] mat3 = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                mat1[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
               System.out.print( mat1[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                mat2[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
               System.out.print( mat2[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<2;k++){
                    mat3[i][j]=mat3[i][j]+mat1[i][k]*mat2[k][i];
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(mat3[i][j]);
            }
            System.out.println(" ");
        }
    }
}
