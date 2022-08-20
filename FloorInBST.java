public class Solution {
    public static TreeNode <Integer> prev = null;
    public static int floorInBST(TreeNode<Integer> root, int X) {
           if(root==null){
               return prev.data;
           }
        if(root.data==X){
            return root.data;
        }
        if(root.data<X){
            prev=root;
            return floorInBST(root.right,X);
        }
        else{
            return floorInBST(root.left,X);
        }
    }
    
}