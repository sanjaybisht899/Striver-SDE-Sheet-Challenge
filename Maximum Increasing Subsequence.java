class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int dp[]= new int[n];
	    
	    for(int i=0;i<n;i++){
	        dp[i]=arr[i];
	    }
	    //Since we are starting from the 1st element so consitering the first to be max.
	    int max=arr[0];
	    for(int i=1;i<n;i++){
	        //Going back and checking whose sum is max and updating our current max
	        for(int j=i;j>=0;j--){
	            if(arr[i]>arr[j]){
	                dp[i]=Math.max(dp[i],dp[j]+arr[i]);
	            }
	        }
	        max=Math.max(dp[i],max);
	    }
	    //System.out.println(Arrays.toString(dp));
	    return max;
	} 
	
}