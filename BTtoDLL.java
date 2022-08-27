class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node head=null;
    Node prev=null;
    Node bToDLL(Node root)
    {
	    helper(root);
	    return head;
    }
    void helper(Node root){
        if(root==null){
	        return;
	    }
	    helper(root.left);
	    if(prev==null){
	        head=root;
	    }
	    else{
	        root.left=prev;
	        prev.right=root;
	    }
	    prev=root;
	    helper(root.right);
	     
    }
}