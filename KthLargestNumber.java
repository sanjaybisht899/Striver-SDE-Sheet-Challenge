class KthLargestNumber {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> q = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            q.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(q.peek()<nums[i]){
                q.poll();
                q.add(nums[i]);
            }
        }
        return q.peek();
    }
}