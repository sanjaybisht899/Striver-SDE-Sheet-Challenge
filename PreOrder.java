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
		Stack<TreeNode> st = new Stack<>();
		// TreeNode current = root;
		while (root != null || !st.isEmpty()) {
            
		    while (root != null) {
                ans.add(root.val);
		        st.push(root);
		        root = root.left;
		    }
		    root = st.pop();
		    
		    root = root.right;
		}
        return ans; 
    }
}