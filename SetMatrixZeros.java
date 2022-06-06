import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int matrix[][]) {
        // Write your code here..
        int col[] = new int[matrix.length];
        int row[] = new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    col[i]=1;
                    row[j]=1;
                }
            } 
        }
        for(int i=0;i<col.length;i++){
              if(col[i]==1){
                  ZeroC(i,matrix);
              }
        }
        for(int i=0;i<row.length;i++){
              if(row[i]==1){
                  ZeroR(i,matrix);
              }
        }
        
    }
    public static void ZeroC(int x, int matrix[][]){
        for(int i=0;i<matrix[0].length;i++){
            matrix[x][i]=0;
        }
    }
    public static void ZeroR(int x, int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            matrix[i][x]=0;
            
        }
    }

}