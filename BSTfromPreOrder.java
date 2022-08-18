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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,new int[]{0},Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode helper(int []preorder, int i[],int min,int max){
        int index=i[0];
        if(index>=preorder.length){
            return null;
        }
        int temp = preorder[index];
        if(temp<min | temp>max){
            return null;
        }
        i[0]++;
        TreeNode root=new TreeNode(temp);
        root.left=helper(preorder,i,min,preorder[index]);
        root.right=helper(preorder,i,preorder[index],max);
        
        return root;
    }
}