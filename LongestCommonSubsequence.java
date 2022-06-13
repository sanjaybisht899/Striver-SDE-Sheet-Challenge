import java.util.*;
public class LongestCommonSubsequence {
    public static int lengthOfLongestConsecutiveSequence(int[] nums, int N) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
            
        }
        
        int max=Integer.MIN_VALUE;
        int prevalue=Integer.MIN_VALUE;
        int curr=0;
        for(int i:map.keySet()){
            if(prevalue!=Integer.MIN_VALUE){
                if(prevalue+1==i){
                    curr++;
                    prevalue=i;
                }else{
                    max=Math.max(max,curr);
                    curr=1;
                    prevalue=i;
                }
            }else{
                prevalue=i;
                curr=1;
            }
        }
         max=Math.max(max,curr);
        return max;
    }
    public static void main(String[] args) {
    }
}
