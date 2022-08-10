class Solution
{
	ArrayList <Integer> boundary(Node root)
	{
	    ArrayList <Integer> result= new ArrayList<>();
	    if(root==null){
	        return result;
	    }
	    result.add(root.data);
	    traverseLeft(root.left,result);
	    
	   //InOrder Traversal
	   traverseInorder(root.left,result);
	   traverseInorder(root.right,result);
	   
	   //Right
	   traverseRight(root.right,result);
	   
	   return result;
	}
	void traverseLeft(Node root,ArrayList<Integer> result){
	    if((root==null) || (root.left==null && root.right==null)){
	        return;
	    }
	    result.add(root.data);
	    if(root.left!=null){
	        traverseLeft(root.left,result);
	    }
	    else{
	        traverseLeft(root.right,result);
	    }
	}
	void traverseInorder(Node root,ArrayList<Integer> result){
	    if(root==null){
	        return;
	    }
	    if(root.left==null && root.right==null){
	        result.add(root.data);
	    }
	    traverseInorder(root.left,result);
	    traverseInorder(root.right,result);
	}
	void traverseRight(Node root,ArrayList<Integer> result){
	    if((root==null) || (root.left==null && root.right==null)){
	        return;
	    }
	    if(root.right!=null){
	        traverseRight(root.right,result);
	    }
	    else{
	        traverseRight(root.left,result);
	    }
	    result.add(root.data);
	} 
	
}
