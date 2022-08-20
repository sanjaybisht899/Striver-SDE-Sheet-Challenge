class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr=root;
        int prev=-1;
        while(curr!=null){
            while(curr!=null){
                prev=curr.val;
                curr=curr.left;
            }
            if(curr!=null){
                prev=curr.val;
                curr=curr.right;
            }
        }
        return prev+k-1;
    }
}