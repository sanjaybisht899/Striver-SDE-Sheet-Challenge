class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int temp[]=new int[n];
        int result=merge(0,n-1,nums,temp);
        return result;
    }
    public int merge(int left,int right,int []nums,int []temp){
        int result=0;
        if(left<right){
            int mid=left+ (right-left)/2;
            result+=merge(left,mid,nums,temp);
            result+=merge(mid+1,right,nums,temp);
            result+=mergeSort(left,mid,right,nums,temp);
        }
        return result;
    }
    public int mergeSort(int left,int mid,int right,int []nums,int []temp){
        
        int result=0;
        int i=left;
        int j=mid+1;
        //Merge Sort Modification
        for(i=left;i<=mid;i++){
            //Taken long as by doubling it can be greater than Integer.MAX_VALUE
            while(j<=right && nums[i]>(long)2*nums[j]){
                j++;
            }
            //Taking the elemets number of elements satisfy the values on right
            result+=j-mid-1;
        }
        i=left;
        j=mid+1;
        int x=left;
        
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                temp[x++]=nums[i++];
            }
            else{
                temp[x++]=nums[j++];
            }
        }
        while(i<=mid){
            temp[x++]=nums[i++];
        }
        while(j<=right){
            temp[x++]=nums[j++];
        }
        for(i=left;i<=right;i++){
            nums[i]=temp[i];
        }
        return result;
    }
}