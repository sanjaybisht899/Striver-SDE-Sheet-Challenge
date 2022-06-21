import java.util.*;
public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		// Write your code here.
        
        int nums[]= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=arr.get(i);
        }
        int sum=1;
        int prev;
        if(n<=1){
            return n;
        }
        prev=nums[0];
        int unique=0;
        for(int i=1;i<n;i++){
            if(prev==nums[i]){
                continue;
            }
            else{
                sum++;
                unique++;
                prev=nums[i];
                nums[unique]=nums[i];
            }
        }
        return sum;
	}
}