class Solution {
    public int longestConsecutive(int[] nums) {
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
}

public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int n : nums) {
        set.add(n);
    }
    int best = 0;
    for(int n : set) {
        if(!set.contains(n - 1)) {  // only check for one direction
            int m = n + 1;
            while(set.contains(m)) {
                m++;
            }
            best = Math.max(best, m - n);
        }
    }
    return best;
}