//Recursive
class Solution {
    boolean check=true;
    public boolean isSymmetric(TreeNode root) {
        helper(root.left,root.right);
        return check;
    }
    public void helper(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return;
        }
        if(p==null && q!=null || q==null && p!=null || p.val!=q.val){
            check=false;
            return;
        }
        helper(p.left,q.right);
        helper(p.right,q.left);
        
    }
    
}
//Iterative
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q1 = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();
    q1.add(root.left);
    q2.add(root.right);
    while(!q1.isEmpty() && !q2.isEmpty()){
        TreeNode node1 = q1.poll();
        TreeNode node2 = q2.poll();
        if(node1==null && node2==null){
            continue;
        }
        if(node1==null || node2==null || node1.val!=node2.val){
            return false;
        }
        q1.add(node1.right);
        q1.add(node1.left);
        q2.add(node2.left);
        q2.add(node2.right);
       
    }
    return true;
}