class Solution {
    boolean result=true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if(left>right+1 || right>left+1){
            result=false;
        }
        return Math.max(left,right)+1;
    }
}
