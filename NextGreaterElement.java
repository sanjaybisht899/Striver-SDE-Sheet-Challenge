class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[nums2.length];
        int result[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        for(int i=nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                res[i]=-1;
                stack.push(nums2[i]);
                continue;
            }
            else{
                if(stack.peek()>nums2[i]){
                    res[i]=stack.peek();
                    stack.push(nums2[i]);
                }
                else{
                    while(!stack.isEmpty() && stack.peek()<nums2[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        res[i]=-1;
                    }
                    else{
                        res[i]=stack.peek();
                    }
                    stack.push(nums2[i]);
                }
            }
        }
        
        for(int i=nums2.length-1;i>=0;i--){
            if(map.getOrDefault(nums2[i],-1)!=-1){
                result[map.getOrDefault(nums2[i],-1)]=res[i];
            }
        }
        return result;
    }
}