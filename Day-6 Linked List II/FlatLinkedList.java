/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class FlatLinkedList
{
    Node flatten(Node root)
    {
        if(root==null || root.next==null){
            return root;
        }
	        Node dummy = new Node(0);
	        
	    while(root.next!=null){
	        Node X=dummy;
	        Node first= root;
	        root=root.next;
	        Node second = root;
	        while(first!=null && second!=null){
	            if(first.data<second.data){
    	            X.bottom=first;
    	            first=first.bottom;
    	         }
    	        else{
    	            X.bottom=second;
    	            second=second.bottom;
    	        }    
    	            X=X.bottom;
	        }
	        if(first!=null){
	            X.bottom=first;
	        }
	        else{
	            X.bottom=second;
	        }
	        Node z=dummy.bottom;
	        
	        
	        z.next=root.next;
	        root=z;
	        
	    }
	    return dummy.bottom;
    }
}