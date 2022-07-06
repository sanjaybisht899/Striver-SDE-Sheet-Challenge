class AllocateBooks {
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0,result=-1;
        for(int i : weights){
            right+=i;
        }
        while(left<=right){
            int mid=(left+right)/2;
            if(isPossible(mid,days,weights)){
                result=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return result;
    }
    public boolean isPossible(int mid, int days, int []weights){
        int count=1,sum=0;
        for(int i : weights){
            if(sum+i<=mid){
                sum+=i;
            }
            else{
                count++;
                if(count>days || i>mid){
                    return false;
                }
                sum=i;
            }
        }
        return true;
    }
}