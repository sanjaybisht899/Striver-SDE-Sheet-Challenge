/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderTraversal = new ArrayList<>();
        preorderTraversalUtil(root,preorderTraversal);
        return preorderTraversal;
    }
    public void preorderTraversalUtil(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        result.add(root.val);
        preorderTraversalUtil(root.left,result);
        preorderTraversalUtil(root.right,result);
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
        if(root!=null){
            stack.push(root);
        }
        
		while (!stack.isEmpty()) {
            root=stack.pop();
            ans.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
		}
        return ans; 
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        TreeNode curr= root;
        
        while(curr!=null){
            if(curr.left==null){
                result.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right !=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    result.add(curr.val);
                    curr=curr.right;
                    
                }
            }
            
        }
        
        return result;
    }
}