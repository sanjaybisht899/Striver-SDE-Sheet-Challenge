
//Using Modified Kadane's Algo / DP
int maxProduct(vector<int>& nums) {
    int n = nums.size();
    int mp=nums[0];
    int mn=nums[0];
    int maxx=nums[0];
    
    for(int i=1;i<n;i++){
        if(nums[i]<0){
            int temp1=mp*nums[i];
            int temp2=mn*nums[i];
            mn=min(nums[i],temp1);
            mp=max(nums[i],temp2);
        }
        else{
           mn=min(nums[i],mn*nums[i]);
           mp=max(nums[i],mp*nums[i]); 
        }
        maxx=max(mp,maxx);
    }
    return maxx;
}
