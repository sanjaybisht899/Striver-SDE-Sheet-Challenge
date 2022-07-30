public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
                inOrderTrv(root, ans);
    return ans;
}
public void inOrderTrv(TreeNode root, List<Integer> ans){
    if(root == null){
        return;
    }
    inOrderTrv(root.left, ans);
    
    inOrderTrv(root.right, ans);
    ans.add(root.val);
            
}
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    if(root!=null){
        stack1.push(root);
    }
    while (!stack1.isEmpty()) {
        TreeNode temp = stack1.pop();
        stack2.push(temp);
        if(temp.left!=null){
            stack1.push(temp.left);
        }
        if(temp.right!=null){
            stack1.push(temp.right);
        }
    }
    while(!stack2.isEmpty()){
        ans.add(stack2.pop().val);
    }
    return ans;
}