class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        //DP array to store the maximum of the count of increasing subarray
        int dp[]= new int[n];
        int result=0;
        //by default each element can be in increasing order so adding 1 to all
        Arrays.fill(dp,1);
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                //checking from the left to the right to see if there is any element greater than the 
                //current so that we will add the max to the array.
                if(nums[i]<nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(result,dp[i]);
        }
        //We will be finding curr + 1 always as we have already computed for the rest in that
        //particular on what we have found
        return result;
    }
}