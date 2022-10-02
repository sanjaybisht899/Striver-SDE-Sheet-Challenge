import java.util.*;
public class RotateMatrix {
    public static void main(String[] args) {
        int arr[][]= new int[3][3];
        int x=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=x;
                x++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        /*
        1 2 3 4
        8 12 16 15
        14 13 9 5
        6 7 11 10
         */
        int count=0;
        int total=9;
        int colstart=0;
        int colend=2;
        int rowstart=0;
        int rowend=2;
        
        while(rowstart<=rowend && colstart <=colend){
            
            if(rowstart==rowend || colstart == colend){
                break;
            }
            int prev=arr[rowstart+1][colstart];
            int curr;
            for(int i=colstart;i<=colend && count<total ;i++){
                curr=arr[rowstart][i];
                arr[rowstart][i]=prev;
                prev=curr;
                count++;
            }
            rowstart++;
            for(int i=rowstart;i<=rowend && count<total ;i++){
                curr=arr[i][colend];
                arr[i][colend]=prev;
                prev=curr;
            }
            colend--;
            
            if(rowstart <= rowend){
                for(int i=colend;i>=colstart && count<total ;i--){
                    curr=arr[rowend][i];
                    arr[rowend][i]=prev;
                    prev=curr;
                }
                
            }
            rowend--;
            if (colstart <= colend){
                for(int i=rowend;i>=rowstart && count<total ;i--){
                    curr=arr[i][colstart];
                    arr[i][colstart]=prev;
                    prev=curr;
                }
                
            }
            colstart++;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
    }
}


class Solution {
    public void rotate(int[][] matrix) {
        //Make Transpose of Matrix 
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(matrix,i,j);
            }
        }
        //Reverse the elements of the array
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }
    public void swap(int [][]swap,int i,int j){
        int temp=swap[i][j];
        swap[i][j]=swap[j][i];
        swap[j][i]=temp;
    }
}