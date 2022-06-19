import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class CopyLinkedListRandom {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		if(head==null){
            return head;
        }
            LinkedListNode curr=head;
            while(curr!=null){
                LinkedListNode temp=curr.next;
                curr.next=new LinkedListNode(curr.data);
                curr.next.next=temp;
                curr=temp;
            }
            curr=head;
            while(curr!=null){
                if(curr.next!=null){
                    curr.next.random=curr.random!=null?curr.random.next:null;
                }
                curr=curr.next.next;
            }
            curr=head;
            LinkedListNode copy=curr.next;
            LinkedListNode tmp=copy;
            while(curr!=null && copy!=null){
                curr.next=curr.next!=null?curr.next.next:curr.next;
                copy.next=copy.next!=null?copy.next.next:copy.next;
                curr=curr.next;
                copy=copy.next;
            }
            
            return tmp;
	}
}
