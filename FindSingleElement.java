class FindSingleElement {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n<2){
            return n;
        }
        int left=0;
        int right=n-2;
        
        while(left<=right){
            int mid=(right+left)/2;
            if(mid%2==0){
                if(nums[mid]!=nums[mid+1]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(nums[mid]==nums[mid+1]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }
        return nums[left];
    }
}