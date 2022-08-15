class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node root) {
        if(root==null){
            return;
        }
        Node left= root.left;
        Node right=root.right;
        
        root.left=right;
        root.right=left;
        
        mirror(root.left);
        mirror(root.right);
    }
    
}