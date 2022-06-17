/**
 * MiddleLinkedList
 */
public class MiddleLinkedList {
    public static Node findMiddle(Node head) 
    {
        Node slow=head;
        Node fast=head;
        while(slow.next!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast.next!=null){
                fast=fast.next;
            }
        }
        return slow;
    }
        
    
}
