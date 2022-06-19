import java.util.* ;
import java.io.*; 
public class ThreeSome {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] nums, int n, int K)  {

	            ArrayList<ArrayList<Integer>> threeSum = new ArrayList<>();

        if(3>n){
            return threeSum;
        }
        Arrays.sort(nums);
        HashSet <List<Integer>> set = new HashSet<>();
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==K){
                    ArrayList <Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    if(set.add(temp)){
                        threeSum.add(temp);
                    }

                    right--;
                    
                }
                if(sum>K){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return threeSum;

	}
}
