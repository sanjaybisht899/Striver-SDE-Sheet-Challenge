class Solution {
    boolean check=true;
    public boolean isValidBST(TreeNode root) {
        helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return check;
    }
    public void helper(TreeNode root,long min, long max){
        if(root==null){
            return;
        }
        if(root.val<=min || root.val>=max){
            check=false;
            return;
        }
        helper(root.left,min,root.val);
        helper(root.right,root.val,max);
    }
}