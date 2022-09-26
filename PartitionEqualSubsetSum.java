class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum/=2;
        return helper(0,nums,sum);
    }
    boolean helper(int index,int nums[],int sum){
        if(index==nums.length){
            return false;
        }
        if(sum==0){
            return true;
        }
        boolean include=helper(index+1,nums,sum-nums[index]);
        boolean exclude=helper(index+1,nums,sum);
        
        return include || exclude;
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum/=2;
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,nums,sum,dp);
    }
    boolean helper(int index,int nums[],int sum,int dp[][]){
        if(index==nums.length || sum<0){
            return false;
        }
        if(sum==0){
            return true;
        }
        if(dp[index][sum]!=-1){
            if(dp[index][sum]==1){
                return true;
            }
            return false;
        }
        boolean include=helper(index+1,nums,sum-nums[index],dp);
        boolean exclude=helper(index+1,nums,sum,dp);
        
        if(include || exclude == true){
            dp[index][sum]=1;
        }
        else{
            dp[index][sum]=0;
        }
        return include || exclude;
    }
}