/**
 * NextPermutation
 */
import java.util.*;
public class NextPermutation {
    public static void nextPermutation(int[] arr) {
        int i =arr.length-2;
        while(i>=0 && arr[i]>arr[i+1] ){
            i--;
        }
        if(i>=0){
            int j=arr.length-1;
            while (j>=0 &&  arr[i]>arr[j]){
                j--;
            }
            swap(i,j,arr);
        }
        reverse(arr,i+1,arr.length-1);
    }
    public static void main(String[] args) {
        int arr[]= {2,3,1,5,4};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    static void swap(int x,int y,int arr[]){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    static void reverse(int arr[],int left , int right){
        while(left<right){
            swap(left,right,arr);
            left++;
            right--;
        }
    }
}