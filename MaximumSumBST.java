//TLE Approach
class Solution {
    int max=0;
    boolean check=true;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        check=true;
        validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        if(check){
            int size=nodes(root);
            max=Math.max(max,size);
        }
        helper(root.left);
        helper(root.right);
        
    }
    public void validateBST(TreeNode root,int min, int max){
        if(root==null){
            return;
        }
        if(root.val<=min || root.val>=max){
            check=false;
            return;
        }
        validateBST(root.left,min,root.val);
        validateBST(root.right,root.val,max);
    }
    public int nodes(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val + nodes(root.left) + nodes(root.right);
    }
}

//Optimal
class Solution {
    int ans=0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
    public Pair helper(TreeNode root){
        if(root==null){
            return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
        }
        
        Pair left =helper(root.left);
        Pair right=helper(root.right);
        
        Pair currNode=new Pair(0,0,false,0);
        
        currNode.size= left.size+right.size+root.val;
        currNode.min= Math.min(root.val,left.min);
        currNode.max= Math.max(root.val,right.max);
        
        if(left.isBST && right.isBST && root.val > left.max && root.val<right.min){
            currNode.isBST=true;
            ans=Math.max(ans,currNode.size);
        }
        return currNode;
    }
}
class Pair{
    int min;
    int max;
    boolean isBST;
    int size;
    public Pair(int min,int max,boolean isBST, int size){
        this.min=min;
        this.max=max;
        this.isBST=isBST;
        this.size=size;
    }
}