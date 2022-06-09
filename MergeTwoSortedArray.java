import java.util.* ;
import java.io.*; 
public class MergeTwoSortedArray {
    public static int[] ninjaAndSortedArrays(int nums1[], int nums2[], int m, int n) {
        int arr[] = new int[nums1.length];
        int i=0,j=0,x=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                arr[x]=nums1[i];
                i++;
            }
            else{
                arr[x]=nums2[j];
                j++;
            }
            x++;
        }
        while(i<m){
            arr[x]=nums1[i];
            i++;
            x++;
        }
        while(j<n){
            arr[x]=nums2[j];
            j++;
            x++;
        }
        
        return arr;
    }
}
