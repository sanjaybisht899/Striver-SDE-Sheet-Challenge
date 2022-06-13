import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        int result[] = new int[2];
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.getOrDefault(target - arr[i], 0)!=1){
                map.put(arr[i],1);
            }
            else{
                result[0]=arr[i];
                result[1]=target-arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[]= {2,7,11,15};
        int target=9;
        int x[]= twoSum(arr,target);
        
        System.out.println(x[0]);
        System.out.println(x[1]);
    }
}
