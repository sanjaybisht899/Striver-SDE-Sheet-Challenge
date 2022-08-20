 public static int findCeil(TreeNode<Integer> root, int X) {
        int prev = -1;
           if(root==null){
               return prev;
           }
        TreeNode <Integer> curr=root;
        while(curr!=null){
            if(curr.data==X){
                return curr.data;
            }
        if(curr.data>X){
            prev=curr.data;
            curr=curr.left;
            
        }
        else{
             curr=curr.right;
        }
        }
        return prev;
    }
    
}
