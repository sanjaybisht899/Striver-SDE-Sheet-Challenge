/**
 * InorderTraversal
 */
public class InorderTraversal {
    //Recusive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderTrv(root, ans);
        return ans;
    }
    public void inOrderTrv(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        inOrderTrv(root.left, ans);
        ans.add(root.val);
        inOrderTrv(root.right, ans);
    
    }

    //Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        // TreeNode current = root;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans; 
    }
    public static void main(String[] args) {
        
    }
}