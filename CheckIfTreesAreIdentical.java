class Solution {
    boolean equal=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p,q);
        return equal;
    }
    public void check(TreeNode p, TreeNode q){
        if(p == null && q != null || q == null && p != null ){
            equal=false;
            return;
        }
        if(p==null && q ==null){
            return;
        }
        if(p.val != q.val){
            equal=false;
            return;
        }
        isSameTree(p.left,q.left);
        isSameTree(p.right,q.right);
    }
}