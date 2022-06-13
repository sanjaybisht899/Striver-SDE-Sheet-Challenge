import java.util.* ;
import java.io.*; 
public class FourSome {
  public static String fourSum(int[] arr, int target, int n) {
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int left=j+1;
                int right=n-1;
                int sum;
                while(left<right){
                    sum=arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum==target){
                          return "Yes";
                    }
                    else if(target>sum){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return "No";
  }
}
