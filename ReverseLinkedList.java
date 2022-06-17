/**
 * ReverseLinkedList
 */
public class ReverseLinkedList {
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        LinkedListNode prev= null;
        while(head!=null){
            LinkedListNode next= head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }    
}