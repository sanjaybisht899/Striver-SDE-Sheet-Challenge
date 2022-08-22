class Solution {
    boolean result=false;
    public boolean findTarget(TreeNode root, int k) {
        
        HashSet<Integer> set = new HashSet<>();
        PreOrder(root,set,k);
        return result;
    }
    public void PreOrder(TreeNode root, HashSet<Integer> set,int k){
        if(root==null){
            return;
        }
        PreOrder(root.left,set,k);
        
        if(set.contains(k-root.val)){
            result=true;
            return;
        }
        else{
            set.add(root.val);
        }
        PreOrder(root.right,set,k);
    }
}