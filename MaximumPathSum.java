class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,sum(root.left));
        int right=Math.max(0,sum(root.right));
        max= Math.max(max,left+right+root.val);
        return Math.max(left,right) + root.val;
    }
}