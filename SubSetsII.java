class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetsWithDup= new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        int n=nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                if( ( (1<<j)& i ) !=0 ){
                    temp.add(nums[j]);
                }
            }
            Collections.sort(temp);
            if(set.add(temp)){
                subsetsWithDup.add(temp);
            }
        }
       // Collections.sort(subsetsWithDup);
        return subsetsWithDup;
    }
}