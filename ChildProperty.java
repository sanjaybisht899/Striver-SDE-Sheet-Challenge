public class Solution {
    static int help(BinaryTreeNode<Integer> root)
    {
        if (root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        int l=0,r=0,c=0;
        if(root.left!=null)
            l=root.left.data;
        if(root.right!=null)
            r=root.right.data;
        c=l+r;
        if(c<root.data)
        {
            if(root.left!=null)
                root.left.data=root.data;
            if(root.right!=null)
                root.right.data=root.data;
        }
        l=help(root.left);
        r=help(root.right);
        root.data=l+r;
        return root.data;
    }

    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        int c=help(root);
    }
}