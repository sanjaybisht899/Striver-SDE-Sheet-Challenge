
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class LongestSubsetWithZero {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> a) {
        int n=a.size();
        int arr[]= new int[a.size()];
        for(int i=0;i<a.size();i++){
            arr[i]=a.get(i);
        }
        
		HashMap <Long,Integer> map = new HashMap<>();
        long sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            if(sum==0){
                max=i+1;
            }
            else if(map.getOrDefault(sum,-1)==-1){
                map.put(sum,i);            
            }
            else{
                max=Math.max(max,i-map.get(sum));
            }
        }
       
        return max;
	}
}