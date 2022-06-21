import java.util.ArrayList;

public class MaximumConsecutiveOnes {
	public static int longestSubSeg(ArrayList<Integer> nums , int n, int k) {
		int left=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(nums.get(i) == 0){
                k--;
            }
            while(k<0){
                if(nums.get(left)==0){
                    k++;
                }
                left++;
            }
            max=Math.max(i-left+1,max);
        }
        return max;
	}
}