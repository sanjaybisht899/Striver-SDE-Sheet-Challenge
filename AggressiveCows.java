
class AggressiveCows {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=0;
        int right=position[position.length-1]-position[0],result=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(isPossible(mid,m,position)){
                result=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return result;
    }
    public boolean isPossible(int mid, int m, int []positions){
        int count=1;
        int sum=positions[0];
        for(int i : positions){
            if(i-sum>=mid){
                count++;
                if(count==m){
                    return true;
                }
                sum=i;
            }
        }
        return false;
    }
}